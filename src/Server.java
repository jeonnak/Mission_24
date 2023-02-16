// 날씨를 알려 주는 네트워크 서버 클라이언트 프로그램 작성하기

import java.util.Date;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try(
            // 9000번 포트를 사용하는 ServerSocket 객체를 생성
            ServerSocket server = new ServerSocket(9000)){

            // 클라이언트의 연결 요청이 오면 승인하고 Socket 객체 생성
            Socket connection = server.accept();

            // 클라이언트에게 문자열을 보내는 PrintWriter 스트림 생성
            PrintWriter pw = new PrintWriter(connection.getOutputStream(), true);

            // 출력 스트림을 사용해 Date 객체를 문자열 형식으로 출력
            pw.println(new Date());

        }catch (Exception e){}
    }
}