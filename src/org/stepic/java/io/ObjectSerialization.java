package org.stepic.java.io;

import java.io.*;
import java.util.Collection;
import java.util.Objects;

public class ObjectSerialization {
    public static void main(String[] args) throws IOException {
        Animal[] animalM1 = { new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animalM1.length);
        for (int i = 0; i < animalM1.length; i++) {
            oos.writeObject(animalM1[i]);
        }
        oos.close();
//        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());
        Animal[] animalM2 = deserializeAnimalArray(new byte [] {43, 31, 54, 6});

        for (int i = 0; i < animalM2.length; i++) {
            System.out.printf("%d. %s \n", i+1, animalM2[i].getName());
        }
    }

    public static Animal[] deserializeAnimalArray(byte [] data){
        Animal [] deserialized_arr;
        int n = 0;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))){
            n = ois.readInt();
            deserialized_arr = new Animal[n];
            for (int i=0; i<n; i++){
                try {
                    deserialized_arr[i] = (Animal) ois.readObject();
                }
                catch (Exception e){
                    throw new IllegalArgumentException(e);
                }
            }
        }
        catch (Exception e){
            throw new IllegalArgumentException(e);
        }
        return deserialized_arr;
    }
}

class Animal implements Serializable{
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}
