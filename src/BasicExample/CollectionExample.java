package BasicExample;

import java.util.*;
import java.util.Objects;

import BasicExample.A_ExampleList.*;

public class CollectionExample {
    public interface WordLadderII126{};

}

class EmptyCollectionExample{
    public static void main(String[] args){
        List<String> temp = new ArrayList<>();
        // will not raise error.
        for(String s: temp){
            System.out.println(s);
        }
    }
}

class CopyExample{
    public static void main(String[] args){
        List<Integer> temp = new ArrayList<>();
        // will not raise error.
        for(int i: new int[] {1,2,3}){
            temp.add(i);
        }
        List<Integer> sample = List.copyOf(temp);
        temp = new ArrayList<>();
        for(int i: sample){
            System.out.println(i);
        }
    }
}

class ArrayListOptAndIteration implements ListExample, IteratorExample{
    public static void main(String[] args){
        int[] il = new int[]{1,2,3, 4, 5};
        String[] sl = new String[]{"a", "b", "c"};
        List<Integer> al = new ArrayList<>();
        for(int i: il){al.add(i);}
        for(int i=0; i<al.size(); i++){System.out.println(al.get(i));}
        al.set(10, 1);
        al.remove(1);

        // Implement by Iterator
        // Change plural digit to 10 and delete them.
        Iterator<Integer> iter = al.iterator();
        while(iter.hasNext()){
            if((iter.next() % 2)==0) {
                iter.remove();}
        }   // you cannot modify with iter. Use ListIterator

        ListIterator<Integer> liter = al.listIterator();
        while(liter.hasNext()){
            if((liter.next() % 2)==0) {
                liter.set(10); liter.add(11);}
        }   // you cannot delete with iter. Use ListIterator
    }
}


class IteratorExample1212 implements IteratorExample {
    public static void main(String[] args){
        List<Integer> l = new ArrayList<>();
        // use
        Iterator<Integer> iter = l.iterator();
        Iterator<Integer> listIter = l.listIterator();

        while(listIter.hasNext()){
            System.out.println(iter.next());
        }

        // you need a new one for new iteration.
//        while(listIter.hasNext()){
        listIter = l.listIterator();
        while(listIter.hasNext()){
            int i = listIter.next();
            // use iterator to remove.
            if(i==2){ listIter.remove();}
        }
//        while(listIter.hasPrevious())

        // use for this way.
        for(Iterator<Integer> newIter=l.listIterator(); newIter.hasNext();){
            int i= newIter.next();
            if(i==3){
                newIter.remove();
            }
        }

        // black tech
        l.removeIf(i -> i == 3);
    }

}

class Book1212 implements HashEqualsToStringExample, Comparable<Book1212>{
    int isbn; String title, author;

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;      // if o is null, then it can't be equal to 'this'
        if (this == obj) return true;       // if both point to same object, then they are equal
        if (getClass() != obj.getClass()) return false; //if not of same type, they can't be equal
        Book1212 b = (Book1212) obj;                  //now that we know obj is unique, non-null Book object, cast it to Book
        return title.equals(b.title) && author.equals(b.author) && (isbn == b.isbn); //compare values
    }

    @Override
    public int compareTo(Book1212 o) {
        return this.isbn-o.isbn;
    }
}




// 181212 Example from ppt 6.6

abstract class Animal {
    public abstract void introduce();
}
interface Pet {
    public void petRequest();
}


class PolymorphicZoo {

    public static void main(String args[]) {
        PolymorphicZoo pittsburghZoo= new PolymorphicZoo();
        Animal species = pittsburghZoo.getSpecies();
        species.introduce();
        // TODO: Note that whoever implements Pet is instance of Pet.
//        if (species instanceof Dog) ((Dog)species).petRequest();
        if (species instanceof Pet) ((Pet)species).petRequest();
    }

    public Animal getSpecies() {
        Animal species = null;
        Random r = new Random();
        int number = r.nextInt(3);

        switch (number) {
            case 0: species = new Tiger(); break;
            case 1: species = new Lion(); break;
            case 2: species = new Dog(); break;
            default: break;
        }
        return species;
    }
}

class Dog extends Animal implements Pet {
    @Override
    public void introduce() {
        System.out.println("Bark...");
    }
    public void petRequest(){ // interface method
        System.out.println ("Wagging tail!");
    }
}
class Tiger extends Animal {
    @Override
    public void introduce() {
        System.out.println("Grrrr...");
    }
}

class Lion extends Animal {
    @Override
    public void introduce() {
        System.out.println("Roar...");
    }
}


