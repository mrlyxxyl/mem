import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class XMemCacheTest {
    private static MemcachedClient client;

    static {
        try {
            MemcachedClientBuilder builder = new XMemcachedClientBuilder("192.168.1.200:11211 192.168.1.200:11212");
            client = builder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            set();
            get();
            client.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void set() throws InterruptedException, MemcachedException, TimeoutException {
        client.set("name", 0, "11111");
        client.set("age", 0, "1111");
        client.set("sex", 0, "111");
        client.set("address", 0, "11111");
    }

    public static void get() throws InterruptedException, MemcachedException, TimeoutException {
        System.out.println(client.get("age"));
        System.out.println(client.get("sex"));
        System.out.println(client.get("address"));
        System.out.println(client.get("name"));
    }
}
