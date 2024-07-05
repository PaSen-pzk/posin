package com.posin.blog.sftp;

/**
 * @author zkP
 * @date 2024/6/13 21:55
 * @func
 * @description
 */
import java.util.Map;
import java.util.Properties;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SFTPChannel {

    private SFTPConstants sftp;

    public SFTPChannel(SFTPConstants sftpConstants) {
        this.sftp = sftpConstants;
    }

    Session session = null;
    Channel channel = null;

    //登录sftp
    public ChannelSftp getChannel(Map<String, String> sftpDetails, int timeout) throws JSchException {
        String ftpHost = sftpDetails.get(SFTPConstants.SFTP_REQ_HOST);
        String port = sftpDetails.get(SFTPConstants.SFTP_REQ_PORT);
        String ftpUserName = sftpDetails.get(SFTPConstants.SFTP_REQ_USERNAME);
        String ftpPassword = sftpDetails.get(SFTPConstants.SFTP_REQ_PASSWORD);

        int ftpPort = SFTPConstants.SFTP_DEFAULT_PORT;
        if (port != null && !port.equals("")) {
            ftpPort = Integer.valueOf(port);
        }

        //创建JSch对象
        JSch jsch = new JSch();
        //根据用户名，主机ip，端口获取一个Session对象
        session = jsch.getSession(ftpUserName, ftpHost, ftpPort);
      log.debug("Session created.");
        if (ftpPassword != null) {
            session.setPassword(ftpPassword);
        }
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        session.setTimeout(timeout); // 设置timeout时间
        session.connect(); // 通过Session建立链接
        log.debug("Session connected.");
        log.debug("Opening Channel.");
        channel = session.openChannel("sftp"); // 打开SFTP通道
        channel.connect(); // 建立SFTP通道的连接
        log.debug("Connected successfully to ftpHost = " + ftpHost + ",as ftpUserName = " + ftpUserName
                + ", returning: " + channel);
        return (ChannelSftp) channel;
    }

    //退出sftp
    public void closeChannel() throws Exception {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }
}

