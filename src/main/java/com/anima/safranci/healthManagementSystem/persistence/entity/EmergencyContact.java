    package com.anima.safranci.healthManagementSystem.persistence.entity;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "emergency_contact")
    public class EmergencyContact {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String firstName;

        @Column(nullable = false)
        private String lastName;

        @Column(nullable = false)
        private String contactPhone;

        @Column
        private String degreeOfKinship;

    }
