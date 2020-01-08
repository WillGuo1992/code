import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageInputStreamImpl;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

public class DatabaseTest {

    public static void main1(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/guozhichao";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "Select * from learnJava";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));

        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/guozhichao";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);

        Blob blob = connection.createBlob();
        int offset = 0;
        OutputStream outputStream = blob.setBinaryStream(offset);
        FileImageInputStream imageInputStream = new FileImageInputStream(new File("1.png"));
        byte[] t = new byte[(int) imageInputStream.length()];
        imageInputStream.read(t);

    }

}
