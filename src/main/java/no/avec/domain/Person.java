package no.avec.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by avec on 25/11/2016.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id = 0L;
    @NonNull private String firstName;
    @NonNull private String lastName;
    @NonNull private int age;
    @NonNull private Sex sex;

    public enum Sex {
        MALE,
        FEMALE
    }
}
