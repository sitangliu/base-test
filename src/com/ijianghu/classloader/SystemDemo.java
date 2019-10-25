package com.ijianghu.classloader;

import java.util.Properties;
import java.util.Set;

/**
 * @author kai
 * @date 2019/10/24
 * @desc base-test
 **/
public class SystemDemo {

    public static void main(String[] args) {

        Properties properties = System.getProperties();
        Set<Object> keySet = properties.keySet();
        for (Object key: keySet) {
            System.out.println("属性："+key+"  -----------------  属性值"+properties.get(key));
            /*属性：java.runtime.name  -----------------  属性值Java(TM) SE Runtime Environment
            属性：sun.boot.library.path  -----------------  属性值D:\develop\Java\jdk1.8.0_66\jre\bin
            属性：java.vm.version  -----------------  属性值25.66-b17
            属性：java.vm.vendor  -----------------  属性值Oracle Corporation
            属性：java.vendor.url  -----------------  属性值http://java.oracle.com/
            属性：path.separator  -----------------  属性值;
            属性：java.vm.name  -----------------  属性值Java HotSpot(TM) 64-Bit Server VM
            属性：file.encoding.pkg  -----------------  属性值sun.io
            属性：user.country  -----------------  属性值CN
            属性：user.script  -----------------  属性值
            属性：sun.java.launcher  -----------------  属性值SUN_STANDARD
            属性：sun.os.patch.level  -----------------  属性值
            属性：java.vm.specification.name  -----------------  属性值Java Virtual Machine Specification
            属性：user.dir  -----------------  属性值E:\IDEAProject\base-test
            属性：java.runtime.version  -----------------  属性值1.8.0_66-b17
            属性：java.awt.graphicsenv  -----------------  属性值sun.awt.Win32GraphicsEnvironment
            属性：java.endorsed.dirs  -----------------  属性值D:\develop\Java\jdk1.8.0_66\jre\lib\endorsed
            属性：os.arch  -----------------  属性值amd64
            属性：java.io.tmpdir  -----------------  属性值C:\Users\kai\AppData\Local\Temp\
            属性：line.separator  -----------------  属性值

            属性：java.vm.specification.vendor  -----------------  属性值Oracle Corporation
            属性：user.variant  -----------------  属性值
            属性：os.name  -----------------  属性值Windows 10
            属性：sun.jnu.encoding  -----------------  属性值GBK
            属性：java.library.path  -----------------  属性值D:\develop\Java\jdk1.8.0_66\bin;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;D:\develop\Java\jdk1.8.0_66\bin;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\Intel\OpenCL SDK\2.0\bin\x86;C:\Program Files (x86)\Intel\OpenCL SDK\2.0\bin\x64;C:\Program Files\TortoiseSVN\bin;D:\develop\apache-maven-3.6.0-bin\apache-maven-3.6.0\bin;C:\WINDOWS\System32\OpenSSH\;D:\Program Files\Git\cmd;D:\ES\nodejs\;D:\devsoft\mysql-8.0.14-winx64\bin;D:\develop\gradle-4.0\bin;C:\Users\kai\AppData\Local\Microsoft\WindowsApps;C:\Users\kai\AppData\Roaming\npm;;.
            属性：java.specification.name  -----------------  属性值Java Platform API Specification
            属性：java.class.version  -----------------  属性值52.0
            属性：sun.management.compiler  -----------------  属性值HotSpot 64-Bit Tiered Compilers
            属性：os.version  -----------------  属性值10.0
            属性：user.home  -----------------  属性值C:\Users\kai
            属性：user.timezone  -----------------  属性值
            属性：java.awt.printerjob  -----------------  属性值sun.awt.windows.WPrinterJob
            属性：file.encoding  -----------------  属性值UTF-8
            属性：java.specification.version  -----------------  属性值1.8
            属性：java.class.path  -----------------  属性值D:\develop\Java\jdk1.8.0_66\jre\lib\charsets.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\deploy.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\ext\access-bridge-64.
            jar;D:\develop\Java\jdk1.8.0_66\jre\lib\ext\cldrdata.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\ext\dnsns.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\ext\jaccess.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\ext\jfxrt.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\ext\localedata.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\ext\nashorn.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\ext\sunec.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\ext\sunjce_provider.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\ext\sunmscapi.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\ext\sunpkcs11.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\ext\zipfs.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\javaws.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\jce.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\jfr.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\jfxswt.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\jsse.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\management- agent.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\plugin.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\resources.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\rt.jar;E:\IDEAProject\base-test\target\classes;C:\Users\kai\.m2\repository\cn\hutool\hutool-all\4.0.5\hutool-all-4.0.5.jar;D:\develop\JetBrains\IntelliJ IDEA 2019.1.1\lib\idea_rt.jar
            属性：user.name  -----------------  属性值kai
            属性：java.vm.specification.version  -----------------  属性值1.8
            属性：sun.java.command  -----------------  属性值com.ijianghu.classloader.SystemDemo
            属性：java.home  -----------------  属性值D:\develop\Java\jdk1.8.0_66\jre
            属性：sun.arch.data.model  -----------------  属性值64
            属性：user.language  -----------------  属性值zh
            属性：java.specification.vendor  -----------------  属性值Oracle Corporation
            属性：awt.toolkit  -----------------  属性值sun.awt.windows.WToolkit
            属性：java.vm.info  -----------------  属性值mixed mode
            属性：java.version  -----------------  属性值1.8.0_66
            属性：java.ext.dirs  -----------------  属性值D:\develop\Java\jdk1.8.0_66\jre\lib\ext;C:\WINDOWS\Sun\Java\lib\ext
            属性：sun.boot.class.path  -----------------  属性值D:\develop\Java\jdk1.8.0_66\jre\lib\resources.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\rt.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\sunrsasign.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\jsse.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\jce.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\charsets.jar;D:\develop\Java\jdk1.8.0_66\jre\lib\jfr.jar;D:\develop\Java\jdk1.8.0_66\jre\classes
            属性：java.vendor  -----------------  属性值Oracle Corporation
            属性：file.separator  -----------------  属性值\
            属性：java.vendor.url.bug  -----------------  属性值http://bugreport.sun.com/bugreport/
            属性：sun.io.unicode.encoding  -----------------  属性值UnicodeLittle
            属性：sun.cpu.endian  -----------------  属性值little
            属性：sun.desktop  -----------------  属性值windows
            属性：sun.cpu.isalist  -----------------  属性值amd64*/
        }


    }
}
