package com.sbt.javaschool.rnd;

import java.util.ArrayList;
import java.util.List;

public class Service implements IService {


    @ICache(
            cacheType = CacheType.FILE,
            fileNamePrefix = "sir.dat",
            zip = true,
            identityBy = {Integer.class},
            lengthList = 100
    )
    public List<Integer> doHardWork(String key, Integer value) {

        return new ArrayList<Integer>();
    }
}
