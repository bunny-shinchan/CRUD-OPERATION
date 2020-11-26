/*Name:SudhanshuVerma
 * Date of Code 15 October 2020*/
package ca.sheridancollege.vermsudh.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Restaurant {
	private Long id;
	private String name;
	private String review;
    private String reviewDate;
    private String reviewTime;
}
