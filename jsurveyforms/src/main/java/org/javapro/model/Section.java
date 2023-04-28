package org.javapro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.eclipse.microprofile.graphql.Description;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class Section  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sectionId;
    @Description("The section name")
    private String name;
    @OneToMany(targetEntity = Question.class)
    @JoinColumn(name="type")
    private List<? extends Question> questions;
}
