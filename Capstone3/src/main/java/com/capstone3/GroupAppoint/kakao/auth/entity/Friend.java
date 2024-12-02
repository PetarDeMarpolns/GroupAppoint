import jakarta.persistence.*;

@Entity
@Table(name = "friend")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // 외래 키 설정
    private User user;

    @Column(nullable = false)
    private String friendName;

    public Friend() {
    }
}
