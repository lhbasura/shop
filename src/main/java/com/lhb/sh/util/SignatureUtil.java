package com.lhb.sh.util;

import com.lhb.sh.util.constant.VerifyConstant;
import org.springframework.util.DigestUtils;

public class SignatureUtil {
    public static String genVerifySignature(int id, long expire) {
        String str = id + "|" + expire + VerifyConstant.VERIFY_SAULT;
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

}
