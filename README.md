# 数据加密解密工具类 #
    操作简单，提供加密解密 Api  
    直接参考sample的代码
     
        switch (view.getId()) {
            case R.id.btn1://加密
                try {
                    String encrypt = DES3.encrypt(KEY2, get());
                    mTemp = encrypt;
                    mTextView2.append("\r\n加密:"+encrypt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn2://解密

                try {
                    String decrypt = DES3.decrypt(KEY2, mTemp);
                    mTextView2.append("\r\n解密:"+decrypt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
       
## Screenshots ##

![image](/art/01.png)