package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Phone;

/**
 * Kristopher Tope - kmtope@dmacc.edu
 * 202102 CIS175 22624
 * Mar 18, 2021
 */


@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long>{
	
}
