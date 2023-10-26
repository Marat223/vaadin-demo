package cit.demo.application.data;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Status extends AbstractEntity {

    String name;
    String value;
}
