import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        // 서버의 IP 주소를 Scanner 객체로 입력받는 코드
        System.out.print("날짜 서버의 IP 주소는? ");
        String serverIP = new Scanner(System.in).nextLine(), line = null;

        try(
                // 서버에 연결할 Socket 객체 생성
                Socket connection = new Socket(serverIP, 9000))  // 서버와 같은 port넘버
            {
            // BufferedReader 스트림 생성
                BufferedReader br = new BufferedReader
                    (new InputStreamReader(connection.getInputStream()));

            // BufferedReader 스트림 사용해서 문자열 읽기
                while ((line = br.readLine()) != null )
                System.out.println(line);
        } catch(Exception e) {}
    }
}