package cn.yingchuang.service.media;

import cn.yingchuang.dao.media.MediaMapper;
import cn.yingchuang.entity.Media;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 祖龙浩 on 2018/3/20.
 */
@Service
public class MediaServiceImpl implements MediaService {

    @Resource
    private MediaMapper mediaMapper;
    @Override
    public List<Media> queryAllMedia() {
        return mediaMapper.queryAllMedia();
    }

    @Override
    public Media queryMediaById(Integer id) {
        return mediaMapper.queryMediaById(id);
    }

    @Override
    public Integer addMediaImage(MultipartFile[] myFiles, Media media) {
        int i = 0;
        int o = 0;
        int j = 0;
        for (MultipartFile file : myFiles) {
            if(file.isEmpty()){
                System.out.println("文件未上传");
            }else{
                //得到上传的文件名
                String fileName = file.getOriginalFilename();
                //得到服务器项目发布运行所在地址
                String path1 = "D:/media/images/";
                //此处未使用UUID来生成唯一标识,用日期作为标识
                String fileNameChange = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + fileName;

                //存储文件的真实路径
                String path = path1 + fileNameChange;
                //数据库中存储的url
                String mediaUrl = "/fileImages/"+fileNameChange;

                //打印文件上传路径,方便查看是否上传成功
                System.out.println(path);
                //把文件上传至path的路径
                File loadFile = new File(path);
                Media cunMedia = new Media();
                try {
                    file.transferTo(loadFile);
                    cunMedia.setMediaUrl(mediaUrl);
                    cunMedia.setMediaName(media.getMediaName()+i++);
                    cunMedia.setMessaage(media.getMessaage()+o++);
                    cunMedia.setMediaParentId(j++);
                    mediaMapper.addMedia(cunMedia);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return 1;
    }


    @Override
    public Integer addMediaVideos(MultipartFile[] myFiles, Media media) {
        int i = 0;
        int o = 0;
        int j = 0;
        for (MultipartFile file : myFiles) {
            if(file.isEmpty()){
                System.out.println("文件未上传");
            }else{
                //得到上传的文件名
                String fileName = file.getOriginalFilename();
                //得到服务器项目发布运行所在地址
                String path1 = "D:/media/videos/";
                //此处未使用UUID来生成唯一标识,用日期作为标识
                String fileNameChange = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + fileName;
                String path = path1 + fileNameChange;
                String mediaUrl = "/fileVideos/"+fileNameChange;
                //打印文件上传路径,方便查看是否上传成功
                System.out.println(path);
                //把文件上传至path的路径
                File loadFile = new File(path);
                Media cunMedia = new Media();
                try {
                    file.transferTo(loadFile);
                    cunMedia.setMediaUrl(mediaUrl);
                    cunMedia.setMediaName(media.getMediaName()+i++);
                    cunMedia.setMessaage(media.getMessaage()+o++);
                    cunMedia.setMediaParentId(j++);
                    mediaMapper.addMedia(cunMedia);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return 1;
    }

    @Override

    public List queryAllVideo() {
        return mediaMapper.queryAllVideo();
    }

    @Override
    public int updateVideo(int id) {
        mediaMapper.updateVideoNo();
        return mediaMapper.updateVideo(id);}

    @Override
    public int updateLunBoTu(Media media) {
        return mediaMapper.updateLunBoTu(media);
    }



    public Media queryMediaByMediaMessage(String mediaMessage) {
        return mediaMapper.queryMediaByMediaMessage(mediaMessage);

    }

    @Override
    public List<Media> queryAllPicture() {
        return mediaMapper.queryAllPicture();
    }
}
