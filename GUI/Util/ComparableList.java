package GUI.Util;

import java.lang.reflect.Array;

public class ComparableList<T extends Comparable> {
    T[] elements;
    int maxDimension;
    int currentNumberOfElements;

    public ComparableList(int maxDimension, Class<T> classType) {
        elements = (T[]) Array.newInstance(classType, maxDimension); 
        this.maxDimension = maxDimension;
    }


    public String showElements() throws EmptyListExc { 
        StringBuilder result = new StringBuilder();
        
        if (currentNumberOfElements == 0) {
            result.append(String.format("The list is empty"));
        } else {
            for (int i = currentNumberOfElements-1; i >= 0 ; i--) {
                result.append(elements[i]);
                result.append("\n");
            }

        }
        return result.toString();
    }

    public void addElements(T addedElement) throws FullListExc { 
            if (currentNumberOfElements == 0) {
                elements[0] = addedElement;
                currentNumberOfElements++;
            } else {
                for (int i = currentNumberOfElements; i > 0; i--) {
                    elements[i] = elements[i - 1];

                }
                elements[0] = addedElement;
                currentNumberOfElements++;
            }
    }

    public void removeElements() throws EmptyListExc {
        if (currentNumberOfElements == 0) {
        } else {
            elements[currentNumberOfElements-1]=null;
            currentNumberOfElements--;

        }
    }

    public void sortElements() throws EmptyListExc { 
        boolean bul = true;
        while(bul){
            bul=false;
                for(int i=0;i<currentNumberOfElements-1;i++){
                    if(elements[i].compareTo(elements[i+1])==-1){
                        bul=true;
                        T temporary = elements[i];
                        elements[i]=elements[i+1];
                        elements[i+1]=temporary;
                    }
                }
        }
     }
}



