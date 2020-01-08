import sun.security.timestamp.TSRequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class BlockingQueueTest {
    public static void main(String[] args) {
        System.out.println("enter base director");
        //Scanner scanner = new Scanner(System.in);
        //File baseDirectory = new File(scanner.next());
        File baseDirectory = new File("C:\\Users\\Administrator\\Downloads");
        //System.out.println("enter a key word");
        String keyWord = "abc";
//        keyWord =  scanner.next();

        final int QUEUE_SIZE = 10;
        final int THREAT_SIZE = 100;

        ArrayBlockingQueue<File> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);
        //查找目录及子目录内文件
        new Thread(new FileSeachTask(queue, baseDirectory)).start();
        //查找keyword
        for (int i = 0; i < THREAT_SIZE; i++) {
            new Thread(new SearchTask(queue, keyWord)).start();
        }
    }


}
class SearchTask implements Runnable {
    private BlockingQueue<File> queue;
    private String keyWord;
    public SearchTask(BlockingQueue<File> queue, String keyWord) {
        this.queue = queue;
        this.keyWord = keyWord;
    }

    @Override
    public void run() {
        boolean done = false;
        while (!done) {
            try {
                File file = queue.take();
                if (file.equals(FileSeachTask.DUMMP)) {
                    done = true;
                    queue.put(file);
                } else {
                    search(file, keyWord);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void search(File file, String keyWord) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str = null;
        int rowNum = 0;
        while (scanner.hasNext()) {
            rowNum++;
            str = scanner.next();
            System.out.println("-----"+str);
            if (str.contains(keyWord)) {
                System.out.printf("%d,%s\n", rowNum, str);
            }
        }
    }
}
class FileSeachTask implements Runnable {
    BlockingQueue<File> queue;
    File directory ;
    static File DUMMP = new File("");
    public FileSeachTask(BlockingQueue<File> queue, File directory) {
        this.queue = queue;
        this.directory = directory;
    }

    @Override
    public void run() {
        try {
            enumrate(directory);
            queue.put(DUMMP);
            System.out.println(queue.toString());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void enumrate(File directory) throws InterruptedException {
        File[] subFiles = directory.listFiles();
        for (File file : subFiles) {
            if (file.isFile()) {
               queue.put(file);
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                enumrate(file);
            }
        }
    }
}
