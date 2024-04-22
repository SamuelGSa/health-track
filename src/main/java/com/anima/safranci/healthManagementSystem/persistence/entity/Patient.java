    package com.anima.safranci.healthManagementSystem.persistence.entity;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import javax.validation.constraints.Email;
    import javax.validation.constraints.NotEmpty;
    import javax.validation.constraints.Size;
    import java.time.LocalDate;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "patient")
    public class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String firstName;

        @Column(nullable = false)
        private String lastName;

        @Column(nullable = false)
        private String contactPhone;

        @Column(nullable = false)
        private LocalDate birthDate;

        @Column(nullable = false, unique = true)
        private String cpf;

        @Column(nullable = false)
        private String email;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "emergency_contact_id", referencedColumnName = "id")
        private EmergencyContact emergencyContact;


//        @OneToOne(cascade = CascadeType.ALL)
//        @JoinColumn(name = "medicalRecord_id", referencedColumnName = "id")
//        private MedicalRecord medicalRecord;

    }
