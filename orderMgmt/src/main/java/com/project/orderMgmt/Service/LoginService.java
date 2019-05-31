package com.project.orderMgmt.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.orderMgmt.DAO.LoginDao;
import com.project.orderMgmt.Model.Login;


@Service("loginService")
public class LoginService {

	@Autowired
	LoginDao loginDao;
	
	@Transactional
	public void savePassword(Login login)
	{
		login.setPassword(getMd5(login.getPassword()));
		loginDao.savePassword(login);
	}
	
	public String getMd5(String input) 
	{ 
		try {  
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			byte[] messageDigest = md.digest(input.getBytes()); 
			BigInteger no = new BigInteger(1, messageDigest);  
			String hashtext = no.toString(16); 
			while (hashtext.length() < 32) { 
				hashtext = "0" + hashtext; 
			} 
			return hashtext; 
		}  
		catch (NoSuchAlgorithmException e) { 
			throw new RuntimeException(e); 
		} 
	}
	
	@Transactional
	public String verify(Login login)
	{
		/*String res=loginDao.verify(login);
		return res;*/
		
		if(login.getUsername().equalsIgnoreCase("Admin"))
		{
			String res=loginDao.verifyAdmin(login);
			return res;
		}
		else if(login.getPassword().equalsIgnoreCase("driver@1234"))
		{
			String res= loginDao.verifyDriver(login);
			return res;
		}
		else
		{
			String res=loginDao.verify(login);
			return res;
		}
	}
	
}
