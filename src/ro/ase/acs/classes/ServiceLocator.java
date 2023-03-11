package ro.ase.acs.classes;

import ro.ase.acs.interfaces.DataInsertor;
import ro.ase.acs.interfaces.DataReader;
import ro.ase.acs.interfaces.TableCreator;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private Map<Type, Object> map = new HashMap<>();

    public ServiceLocator() {
        map.put(TableCreator.class,new CreateTable());
        map.put(DataInsertor.class, new InsertData());
        map.put(DataReader.class, new ReadData());
    }

    public <T> T get(Type contract) {
        return (T)map.get(contract);
    }
}
