package com.govtech.demo.generic;



import java.util.List;


public interface ISqlService<T> {

    List<T> list(String sql);

}
