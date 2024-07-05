package com.posin.blog.sftp;

import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

@Slf4j
public class SFTPUtil {

    private SFTPConfig sftp;

    public SFTPUtil(SFTPConfig sftp) {
        this.sftp = sftp;
    }

    public void uploadFile(String localFilePath, String remoteFilePath) {
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(sftp.getUsername(), sftp.getHost(), sftp.getPort());
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(sftp.getPassword());
            session.connect();

            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            channelSftp.put(new FileInputStream(localFilePath), remoteFilePath);

            channelSftp.disconnect();
            session.disconnect();
        } catch (JSchException | SftpException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void downloadFile(String remoteFilePath, String localFilePath) {
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(sftp.getUsername(), sftp.getHost(), sftp.getPort());
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(sftp.getPassword());
            session.connect();

            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            channelSftp.get(remoteFilePath, new FileOutputStream(localFilePath));

            channelSftp.disconnect();
            session.disconnect();
        } catch (JSchException | SftpException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
