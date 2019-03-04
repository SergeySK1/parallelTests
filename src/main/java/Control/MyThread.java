package Control;


import Driver.SetupDriver;



public class MyThread extends Thread  {



          @Override
          public void run()
          {
              SetupDriver.getDriver();
          }


}
