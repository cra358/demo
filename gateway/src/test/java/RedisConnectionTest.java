import com.chenxw.demo.GatewayApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest(classes = GatewayApplication.class)
class RedisConnectionTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void testConnection() {
        redisTemplate.opsForValue().set("test", "value");
        assert "value".equals(redisTemplate.opsForValue().get("test"));
    }
}