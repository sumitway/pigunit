package com.sumitway.hadoop.pig;

import javassist.CannotCompileException;
import javassist.NotFoundException;

import org.apache.pig.ExecType;
import org.apache.pig.pigunit.PigTest;
import org.apache.pig.pigunit.pig.PigServer;
import org.junit.Before;
import org.junit.Test;

import com.sumitway.hadoop.pig.PigUnitUtil;


public class PigUnitUtilTest {

    @Before
    public void setup() throws NotFoundException, CannotCompileException {
        PigUnitUtil.runFix();
        //FixHadoopOnWindows.runFix();
    }
    
   /* @Test
    public void testTop2Queries() throws Exception {
      String[] args = {
          "n=2",
          };
      System.getProperties().setProperty("mapred.map.child.java.opts", "-Xmx1G");
      System.getProperties().setProperty("mapred.reduce.child.java.opts","-Xmx1G");
      System.getProperties().setProperty("io.sort.mb","10");
      PigTest test = new PigTest("src/test/resources/top_queries.pig", args);
   
      String[] input = {
          "yahoo",
          "yahoo",
          "yahoo",
          "twitter",
          "facebook",
          "facebook",
          "linkedin",
      };
   
      String[] output = {
          "(yahoo,3)",
          "(facebook,2)",
      };
      
      test.assertOutput("data", input, "queries_limit", output);
    }
*/  
    @Test
    public void testStudentsPigScript() throws Exception {
        //PigServer pigServer = new PigServer(ExecType.LOCAL);
        //pigServer.getPigContext().getProperties().setProperty("pig.temp.dir", "D:/TMP");
       // pigServer.getPigContext().getProperties().setProperty("hadoop.tmp.dir", "D:/TMP");

    	PigTest pigTest = new PigTest("src/main/resources/wordcount.pig");
    	//pigTest.getPigServer().getPigContext().getProperties().setProperty("pig.temp.dir", "D:/TMP");
    	//pigTest.getPigServer().getPigContext().getProperties().setProperty("hadoop.tmp.dir", "D:/TMP");
    	pigTest.assertOutput("D", new String[] { "(2,No)", "(3,Ha!)",
    	"(1,Yes)", "(1,Open)", "(3,Papa)", "(1,your)", "(1,Johny)",
    	"(1,lies?)", "(1,Eating)", "(1,Johny!)", "(1,mouth!)",
    	"(1,sugar?)", "(1,Telling)", });
    	}
}

