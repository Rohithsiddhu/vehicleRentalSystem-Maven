package com.example.vehiclerentalsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vehiclerentalsystem.entity.Testimonial;

public interface TestimonialRepository extends JpaRepository <Testimonial,Long> {

}
