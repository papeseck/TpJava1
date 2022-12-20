package com.groupeisi.securiteweb.dao;

import java.util.List;

public interface Repostory <T> {
    public int add(T t);
    public int delete(int id,T t);
    public int update(T t);
    public List<T> list(T t);
    public T get(int id,T t);
}
