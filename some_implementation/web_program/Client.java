package algorithm.some_implementation.web_program;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Socket mysocket = null;
		DataInputStream in= null;
		DataOutputStream out = null;
		Thread readData;
		//String username= null;
		Read read = null;
		try {
			mysocket = new Socket();
			read = new Read();
			readData = new Thread(read);       //
			System.out.println("�����������IP��");
			String IP = scanner.nextLine();
			System.out.println("�����û�����");
			username.username = scanner.nextLine();
			//System.out.println("����˿ں￿);
			//int port = scanner.nextInt();
			int port = 5555;
			if(mysocket.isConnected()){}
			else{
				InetAddress address = InetAddress.getByName(IP);
				InetSocketAddress socketAddress = new InetSocketAddress(address,port);
				mysocket.connect(socketAddress);
				in = new DataInputStream(mysocket.getInputStream());
				out = new DataOutputStream(mysocket.getOutputStream());
				out.writeUTF("��ӭ��"+username.username+"������������");
				read.setDataInputStream(in);
				readData.start();			//
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�������ѶϿ���" + e);
		}
	
		System.out.println("��");
		while(scanner.hasNext()){
			String s = null;
			try {
				s = scanner.nextLine();
			} catch (InputMismatchException exp) {
				// TODO: handle exception
				System.exit(0);
			}
			try {
				out.writeUTF(username.username+":"+s);    //
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
class Read implements Runnable{
	DataInputStream in;
	public void setDataInputStream(DataInputStream in){
		this.in = in;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String s = null;
		while(true){
			try {
				s = in.readUTF();      //
				System.out.println(s);
				System.out.print("��");
			} catch (IOException e) {
				// TODO: handle exception
				System.out.println("��������Ͽ����￿+e");
				break;
			}
		}
	}
}
class username{
	public static String username = null;
}
