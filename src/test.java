public class test {
    public static void main(String[] args) {
      //  MyHashMap<Integer,String> map = new MyHashMap<>();
      //  map.put(1,"Davit");
      //  map.put(2,"John");
      //  map.put(3,"Tigran");

       // System.out.println(map.get(1));
       // System.out.println(map.get(2));
       // System.out.println(map.get(3));
       // System.out.println(map.get(4));

       // map.put(1,"Levon");
       // map.put(1,"Areg");

        //System.out.println(map.get(1));

      //  map.put(1, "Davit");
      //  map.put(17, "Mane");
       // System.out.println(map.get(1));
       // System.out.println(map.get(17));

        MyHashMap<String, Integer> ages = new MyHashMap<>();
        //ages.put("Davit", 22);
        //ages.put("Roland",22);

        //System.out.println(ages.get("Davit"));
        //System.out.println(ages.get("Roland"));

        //System.out.println(ages.get("Artak"));
        ages.put("Aa", 6);
        ages.put("BB", 7);
        ages.put("CollisionCheck", 10);

        System.out.println(ages.get("Aa"));
        System.out.println("Aa".hashCode());
        System.out.println(ages.get("BB"));
        System.out.println("BB".hashCode());
        System.out.println(ages.get("CollisionCheck"));



    }
}
