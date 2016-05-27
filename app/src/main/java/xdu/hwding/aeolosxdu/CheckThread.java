package xdu.hwding.aeolosxdu;

import android.os.Handler;
import java.io.IOException;
import FooPackage.PhysicalExperiment;
import FooPackage.SportsClock;

public class CheckThread extends Thread{
    String ID;
    String spclk;
    String phyexp;
    Handler handler;

    /*
     * TODO
     *      在libXDUQuery中提供缓存验证码目录的函数参数
     *      最后验证ECard模块并要求输入验证码
     */

    CheckThread(String ID, String spclk, String phyexp) {
        this.ID = ID;
        this.spclk = spclk;
        this.phyexp = phyexp;
    }

    public void run() {
        SportsClock sportsClock = new SportsClock();
        PhysicalExperiment physicalExperiment = new PhysicalExperiment();
        try {
            System.out.println(sportsClock.checkIsLogin(
                    sportsClock.login(ID, spclk)
            ));
            System.out.println(physicalExperiment.login(ID, phyexp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
