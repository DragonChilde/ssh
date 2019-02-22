package test.spring.service;

import java.io.InputStream;
import java.util.HashMap;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.spring.common.FtpUtil;
import com.spring.common.SFTPChannel;
import com.spring.common.SFTPConstants;

public class FtpTest {
	
	@Test
	public void FtpTestUpload() {
		HashMap<String,String> hashMap = new HashMap<>();
		hashMap.put("host","192.168.0.232");
		hashMap.put("port","9831");
		hashMap.put("username", "root");
		hashMap.put("password", "2k3fvszVALVk");
		//SFTPConstants sftpConstants = new SFTPConstants();
		SFTPChannel sftpChannel = new SFTPChannel();
		
		String location = "D:\\20160726165633.png";
		String target = "/tmp/temp/test.png";
		try {
			ChannelSftp channel = sftpChannel.getChannel(hashMap, 10000);
			System.out.println(channel);
			sftpChannel.upload(location, target, channel);
		} catch (JSchException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
