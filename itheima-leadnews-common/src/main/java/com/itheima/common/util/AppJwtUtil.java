package com.itheima.common.util;

import com.itheima.common.constants.SystemConstants;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @version 1.0
 * @description 标题
 * @package com.itheima.common.util
 */
public class AppJwtUtil {
    // TOKEN的有效期一秒（S）
    private static final int TOKEN_TIME_OUT = 100*24*3600;
    // 加密KEY
    private static final String TOKEN_ENCRY_KEY = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY";
    // 最小刷新间隔(S)
    private static final int REFRESH_TIME = 300;

    // 生产ID
    public static String createToken(Long id) {
        Map<String, Object> claimMaps = new HashMap<>();
        claimMaps.put("id", id);
        long currentTime = System.currentTimeMillis();
        return Jwts.builder()
            .setId(UUID.randomUUID().toString())
            .setIssuedAt(new Date(currentTime))  //签发时间
            .setSubject("system")  //说明
            .setIssuer("heima") //签发者信息
            .setAudience("app")  //接收用户
            .compressWith(CompressionCodecs.GZIP)  //数据压缩方式
            .signWith(SignatureAlgorithm.HS512, generalKey()) //加密方式
            //过期一个小时
            .setExpiration(new Date(currentTime + TOKEN_TIME_OUT * 1000))  //过期时间戳
            .addClaims(claimMaps) //cla信息
            .compact();
    }

    /**
     * 获取token中的claims信息
     *
     * @param token
     * @return
     */
    private static Jws<Claims> getJws(String token) {
        return Jwts.parser()
            .setSigningKey(generalKey())
            .parseClaimsJws(token);
    }

    /**
     * 获取payload body信息
     *
     * @param token
     * @return
     */
    public static Claims getClaimsBody(String token) {
        return getJws(token).getBody();
    }

    /**
     * 获取hearder body信息
     *
     * @param token
     * @return
     */
    public static JwsHeader getHeaderBody(String token) {
        return getJws(token).getHeader();
    }

    /**
     * 是否过期
     *
     * @param token
     * @return 1 有效  0 无效  2 已过期
     */
    public static int verifyToken(String token) {
        try {
            Claims claims = AppJwtUtil.getClaimsBody(token);
            return SystemConstants.JWT_OK;
        } catch (ExpiredJwtException ex) {
            return SystemConstants.JWT_EXPIRE;
        } catch (Exception e) {
            return SystemConstants.JWT_FAIL;
        }
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getEncoder().encode(TOKEN_ENCRY_KEY.getBytes());
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("UserId",123456);
        map.put("Username","鸡哥");
        long current = System.currentTimeMillis();
        String compact = Jwts.builder().setIssuedAt(new Date(current)).setIssuer("JiJi")
                .setClaims(map).compressWith(CompressionCodecs.GZIP)
                .signWith(SignatureAlgorithm.HS512, "JiJi").compact();
        System.out.println(compact);

        Claims jiJi = Jwts.parser().setSigningKey("JiJi")
                .parseClaimsJws(compact).getBody();
        Integer userId = jiJi.get("UserId", Integer.class);
        System.out.println(userId);
        String username = jiJi.get("Username", String.class);
        System.out.println(username);

        ///* Map map = new HashMap();
       // map.put("id","11");*/
       // String token = AppJwtUtil.createToken(1102L);
       // System.out.println(token);
       //
       // try {
       //     Thread.sleep(2000);
       // } catch (InterruptedException e) {
       //     e.printStackTrace();
       // }
       // int i = AppJwtUtil.verifyToken(token);
       // System.out.println(i);
       // Claims claims = AppJwtUtil.getClaimsBody(token);
       // Integer integer = AppJwtUtil.verifyToken("dsafafsa");
       // System.out.println(integer);
       // System.out.println(claims);

    }
}
