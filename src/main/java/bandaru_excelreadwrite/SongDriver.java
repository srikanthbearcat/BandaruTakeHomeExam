/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandaru_excelreadwrite;

import bandaru_excelreadwrite.Song;
import bandaru_excelreadwrite.ReadfromExcel;
import bandaru_excelreadwrite.ReadfromExcel;
import bandaru_excelreadwrite.Song;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author S525796
 */
public class SongDriver {
    public static void main(String args[]){
         
        
        /*
        creating object of ReadfromExcel class
        */
         ReadfromExcel rd = new ReadfromExcel();
         List songList = rd.getSongsListFromExcel();
         System.out.println(songList);
         
         
       /*
         Sorting the list
         */
        Collections.sort(songList,new Comparator<Song>(){
        
        
        /*
            Sorting by Genre
            */
	@Override
	public int compare(Song arg0, Song arg1) {
		
		return arg0.getGenre().compareTo(arg1.getGenre());
	}
        });
         Collections.sort(songList, new Comparator<Song>(){

        
        
        /*
             Sorting  by Critic score
             */
	@Override
	public int compare(Song o1, Song o2) {
		// TODO Auto-generated method stub
		if(o1.getGenre().equals(o2.getGenre())){
			
			if(o2.getCriticscore()-o1.getCriticscore()<0)
				return -1;
			else if(o2.getCriticscore()-o1.getCriticscore()>0)
				return 1;
			else return 0;
		}
		else{
			
			return 1;
		}
	}
          });
            
         
         
         /*
         Writing to excel
         */
         WritetoExcel wr = new WritetoExcel();
         
         wr.writeSongsListToExcel(songList);
     }
}
