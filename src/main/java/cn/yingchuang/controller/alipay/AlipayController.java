package cn.yingchuang.controller.alipay;

import cn.yingchuang.command.config.AlipayConfig;
import cn.yingchuang.command.util.OrderNumberUtil;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/3/22 0022.
 */
@Controller
@RequestMapping("alipay")
public class AlipayController {
    private static final Logger logger = Logger.getLogger("AlipayController");

    /**
     * 用来接收informationId 的方法,在点击支付的时候传过来的值,用于修改信息里面的状态使用的
     * @param
     * @return
     */

    @RequestMapping(value = "toPay",method = RequestMethod.GET)
    public String toPay(String applyCode,Model model){
        model.addAttribute("applyCode", applyCode);
        return "pay";
    }

    /**
     * 用于接收支付包返回的信息之后跳转的页面显示支付成功的信息
     * 跳转回点击支付的页面
     * @return
     */
    @RequestMapping("toMain")
    public String main(){
        return "";
    }
    @RequestMapping(value="/goPay", method={RequestMethod.POST})
    public String goPay(ModelMap map, HttpServletRequest request, HttpServletResponse response, String rechargeMon) throws Exception {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = OrderNumberUtil.getOrderNo("请读者保证订单号唯一");
        // 订单名称，必填
        String subject = "充值金额" + rechargeMon;
        // 付款金额，必填
        String total_amount = rechargeMon;
        // 商品描述，可空
        String body = "张三充值￥：" + rechargeMon;
        // 封装请求支付信息
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setOutTradeNo(out_trade_no);
        model.setSubject(subject);
        model.setTotalAmount(total_amount);
        model.setBody(body);
        model.setTimeoutExpress("");
        // 销售产品码 必填
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        alipayRequest.setBizModel(model);
        // 调用SDK生成表单
        String form = alipayClient.pageExecute(alipayRequest).getBody();
        map.put("result", form);
        return "alipay";
    }
        /**
         * 用于接收支付包返回的信息之后跳转的页面显示支付成功的信息
         * 跳转回点击支付的页面
         * pc端同步通知
         * @param
         * @return  String
         * @throws  Exception
         * @author  zhangyn
         * @date    2017年6月29日 下午9:45:30
         */
        @RequestMapping(value="returnUrl")
        public String returnUrl(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception{
            logger.info("------------------------------------pc同步通知-------------------------------------------");
            //获取支付宝GET过来反馈信息
            Map<String,String> params = new HashMap<String,String>();
            Map<String,String[]> requestParams = request.getParameterMap();
            for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用
                //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            }

            boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGNTYPE); //调用SDK验证签名

            //——请在这里编写您的程序（以下代码仅作参考）——
            if(signVerified) {
                //商户订单号
                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //支付宝交易号
                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //付款金额
                String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
                response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
                logger.info("-----------------out_trade_no:"+out_trade_no+"trade_no:"+trade_no+"total_amount:"+total_amount+"---------------------");
                map.put("alipayResult", "支付宝充值成功");
            }else {
                response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
                map.put("alipayResult", "支付宝充值失败");
            }
            //——请在这里编写您的程序（以上代码仅作参考）——
            return "";
        }

        /**
         * pc端异步通知
         * @param
         * @return  String
         * @throws  Exception
         * @author  zhangyn
         * @date    2017年6月29日 下午9:45:17
         */
        @RequestMapping(value="notifyUrl",method=RequestMethod.POST)
        public void notifyUrl(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception{
            try {
                logger.info("------------------------------------pc异步通知-------------------------------------------");
                //获取支付宝POST过来反馈信息
                Map<String,String> params = new HashMap<String,String>();
                Map<String,String[]> requestParams = request.getParameterMap();
                for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
                    String name = (String) iter.next();
                    String[] values = (String[]) requestParams.get(name);
                    String valueStr = "";
                    for (int i = 0; i < values.length; i++) {
                        valueStr = (i == values.length - 1) ? valueStr + values[i]
                                : valueStr + values[i] + ",";
                    }
                    //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化。
                    //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
                    params.put(name, valueStr);
                }
                //logger.info("---------------------------------------------------------------params=========="+params);
                //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
                //商户订单号

                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
                //支付宝交易号

                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //交易状态
                String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

                //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
                //计算得出通知验证结果
                //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
                boolean verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, "RSA2");
                logger.info("------------------------------------------支付宝异步通知页面验证成功：trade_finished------------------------------verify_result="+verify_result);
                if(verify_result){//验证成功
                    //////////////////////////////////////////////////////////////////////////////////////////
                    //请在这里加上商户的业务逻辑程序代码

                    //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——

                    if(trade_status.equals("TRADE_FINISHED")){
                        System.out.println("支付成功");
                        //判断该笔订单是否在商户网站中已经做过处理
                        //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                        //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                        //如果有做过处理，不执行商户的业务程序
                        logger.info("------------------------------------------支付宝异步通知页面验证成功：trade_finished------------------------------");
                        //注意：
                        //如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                        //如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
                    } else if (trade_status.equals("TRADE_SUCCESS")){
                        //判断该笔订单是否在商户网站中已经做过处理
                        //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                        //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                        //如果有做过处理，不执行商户的业务程序
                        logger.info("------------------------------------------支付宝异步通知页面验证成功：trade_success------------------------------");
                        //注意：
                        //如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
                    }
                    //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
                    response.getWriter().println("success");
                    response.getWriter().close();
                    //////////////////////////////////////////////////////////////////////////////////////////
                }else{//验证失败
                    System.out.println("验签失败");
                    response.getWriter().println("fail");
                    response.getWriter().close();
                    logger.info("-------------------------------fail-------------------------------");
                }
            } catch (Exception e) {
                response.getWriter().println("fail");
                response.getWriter().close();
                logger.info("跳转到pc网站支付宝支付-同步不通知-页面-error");
                e.printStackTrace();
            }
        }
    }

