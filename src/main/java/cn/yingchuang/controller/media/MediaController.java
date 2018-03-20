package cn.yingchuang.controller.media;

import cn.yingchuang.entity.Media;
import cn.yingchuang.service.media.MediaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Created by 祖龙浩 on 2018/3/20.
 */
@Controller
@RequestMapping("media")
public class MediaController {
    @Resource
    private MediaService mediaService;

    /**
     * media批量传图片
     * @param myFiles
     * @param media
     * @return
     */
    @RequestMapping(value = "addMediaImage",method = RequestMethod.POST)
    public String addMediaImage(@RequestParam MultipartFile[] myFiles, Media media) {


        Integer rows = mediaService.addMediaImage(myFiles, media);

        return null;
    }

    /**
     * media批量视频
     * @param myFiles
     * @param media
     * @return
     */
    @RequestMapping(value = "addMediaVideos",method = RequestMethod.POST)
    public String addMediaVideos(@RequestParam MultipartFile[] myFiles, Media media) {


        Integer rows = mediaService.addMediaVideos(myFiles, media);

        return null;
    }

}
