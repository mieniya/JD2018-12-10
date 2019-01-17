package by.it.subach.jd01_12;
/*names
Abraham, Addison, Adrian, Albert, Alec, Alfred, Alvin, Andrew, Andy, Archibald, Archie, Arlo, Arthur, Arthur, Austen,
Barnabe, Bartholomew, Bertram, Bramwell, Byam, Cardew, Chad, Chance, Colin, Coloman, Curtis, Cuthbert, Daniel, Darryl,
David, Dickon, Donald, Dougie, Douglas, Earl, Ebenezer, Edgar, Edmund, Edward, Edwin, Elliot, Emil, Floyd, Franklin,
Frederick, Gabriel, Galton, Gareth, George, Gerard, Gilbert, Gorden, Gordon, Graham, Grant, Henry, Hervey, Hudson, Hugh,
Ian, Jack, Jaime, James, Jason, Jeffrey, Joey, John, Jolyon, Jonas, Joseph, Joshua, Julian, Justin, Kurt, Lanny, Larry,
Laurence, Lawton, Lester, Malcolm, Marcus, Mark, Marshall, Martin, Marvin, Matt, Maximilian, Michael, Miles, Murray, Myron,
Nate, Nathan, Neil, Nicholas, Nicolas, Norman, Oliver, Oscar, Osric, Owen, Patrick, Paul, Peleg, Philip, Phillipps,
Raymond, Reginald, Rhys, Richard, Robert, Roderick, Rodger, Roger, Ronald, Rowland, Rufus, Russell, Sebastian, Shahaf, Simon,
Stephen, Swaine, Thomas, Tobias, Travis, Victor, Vincent, Vincent, Vivian, Wayne, Wilfred, William, Winston, Zadoc, end
 */
import java.util.*;

public class TaskB2 {
//    private List<String> peoples1 = new ArrayList<>();
//    private List<String> peoples2 = new LinkedList<>();

    public static void main(String[] args) {

//        List<String> peoples1 = new ArrayList<>();
//        List<String> peoples2 = new LinkedList<>();

//        TaskB2 instance = new TaskB2();
//        Scanner scanner = new Scanner(System.in);
//        while(true){
//            String name = scanner.next();
//            if(name.equals("end"))  break;
//            else {
//                name = name.replaceAll("[,]", "");
//                instance.peoples1.add(name);
//                instance.peoples2.add(name);
//            }
//        }
//
//        System.out.println(instance.peoples1);
//        System.out.println("------------------------");
//        System.out.println(instance.peoples2);

    String names = "Abraham1, Addison2, Adrian3, Albert4, Alec5, Alfred6, Alvin7, Andrew8, Andy9, Archibald10, Archie11, Arlo12, Arthur13, Arthur14, Austen15";
    String [] namesArr = names.split(", ");
        System.out.println(Arrays.toString(namesArr));

        List<String> peoples1 = new ArrayList<>(Arrays.asList(namesArr));
        List<String> peoples2 = new LinkedList<>(Arrays.asList(namesArr));

        TaskB2.process((ArrayList<String>) peoples1);
        String lastManStanding = process((ArrayList<String>) peoples1);
        System.out.println(lastManStanding);
    }

    static String process(ArrayList<String> peoples){
        ArrayList<String> killArray = new ArrayList<>(peoples);
        int counter = killArray.size();
        Iterator<String> iter = killArray.iterator();

        while (killArray.size()>1) {
            if (killArray.size() == counter) {
                iter.next();
                if (iter.hasNext()) {
                    iter.next();
                    iter.remove();
                }
            }
//            else if(killArray.size() < counter){
//                if(iter.hasNext()){
//                    iter.next();
//                    iter.remove();
//                }
//            }
        }


        return killArray.toString();
    }
//
//    static String process(LinkedList<String> peoples){
//
//
//    }

 }
