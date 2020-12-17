package com.service.imp;


import com.IoSetting;
import com.PrintSize;
import com.service.ByteStreamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;

@Slf4j
@Service
public class ByteStreamSeviceImpl implements ByteStreamService {

    @Resource
    private IoSetting ioSetting;

    @Override
    public void redAndWriteByte(String filePath) throws Exception {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String outPtah = ioSetting.getFilePath() + filePath.substring(filePath.lastIndexOf("/"), filePath.length());
        System.out.println(outPtah);
        try {
            inputStream = new BufferedInputStream(new FileInputStream(new File(filePath)));
            outputStream = new BufferedOutputStream(new FileOutputStream(new File(outPtah)));
            byte[] bytes = new byte[ioSetting.getBufferSize()];
            int len = 0;
            int sumByte = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                // sumByte = len + sumByte;
                sumByte += len;
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }
            log.info("字节{} ", PrintSize.getNetFileSizeDescription(sumByte));
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
