package com.xdemo.auth.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiMeng
 * @Date 2021.4.30
 * @Description 关于jwt的操作
 */
@Component
public class TokenUtil {

    private static final long EXPIRE_TIME = 15 * 60 * 1000;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy‐MM‐dd hh:mm:ss");

    private static final String SECRET = "t1o2k3e4n5_s9e8c7r6e5t";

    /**
     * 生成签名，15分钟过期
     * @param **username**
     * @param **password**
     * @return
     */
    public static String createToken(Integer userId, String username) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Date now = new Date(System.currentTimeMillis());
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userId)
                    .withClaim("username", username)
                    .withIssuedAt(now)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * token解析，并获取jwt中的用户信息
     * @param **token**
     * @return
     */
    public static Map<String, Object> verifyToken(String token){

        Map<String, Object> jwtObject = new HashMap<>();

        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            jwtObject.put("userId", jwt.getClaim("userId").asInt());
            jwtObject.put("username", jwt.getClaim("username").asString());
            jwtObject.put("createDate", jwt.getIssuedAt()); //签发时间
//            jwtObject.put("createDate", sdf.format(jwt.getIssuedAt())); //签发时间
            jwtObject.put("expireDate", jwt.getExpiresAt()); //过期时间
//            jwtObject.put("expireDate", sdf.format(jwt.getExpiresAt())); //过期时间
            return jwtObject;
        } catch (Exception e){
            return jwtObject;
        }
    }

    /**
     * 检查token是否过期，并解析token
     * @param **token**
     * @return
     */
    public static boolean checkToken(String token){
        try {
            Date now = new Date(System.currentTimeMillis());//当前时间
//            SimpleDateFormat sdf=new SimpleDateFormat("yyyy‐MM‐dd hh:mm:ss");
//            System.out.println("当前时间:"+sdf.format(now) );
            Map<String, Object> jwtObject= verifyToken(token);
            //若当前时间在过期时间之后，则token未过期
            return now.before((Date) jwtObject.get("expireDate"));
        } catch (Exception e){
            return false;
        }
    }

    public static void main(String[] args) {
        String token = createToken(1, "bbbb");
        System.out.println(token);
        Object result = verifyToken(token);
        System.out.println(result);
        checkToken(token);
    }
}
