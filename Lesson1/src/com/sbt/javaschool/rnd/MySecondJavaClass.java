package com.sbt.javaschool.rnd;

import com.sbt.javaschool.rnd.newclass.MyThirdClass;

public class MySecondJavaClass {

    public String ReturnStringData(String _data)
    {
        MyThirdClass thirdClass = new MyThirdClass();
        return _data+"\n Size string = "+ thirdClass.SizeString(_data);
    }
}
