object CollectionBus1 {

    def main(args: Array[String]): Unit = {
      val list1=List(1,2,3)
      println(list1)

      val list2 =list1 :+99
      println(list2)

      val list3=1 :: list2 ::list1 ::Nil
      println(list3)

    }

}
