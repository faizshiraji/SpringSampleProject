package com.doller.vendor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doller.vendor.entities.Vendor;
import com.doller.vendor.repos.VendorRepository;

@RestController
@RequestMapping("/vendors")
public class VendorRESTController {

	@Autowired
	VendorRepository vendorRepository;
	
	@GetMapping
	public List<Vendor> getVendors() {
		return vendorRepository.findAll();
	}
	
	@PostMapping
	public Vendor createVendor(@RequestBody Vendor vendor) {
		return vendorRepository.save(vendor);
	}
	
	@PutMapping
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		return vendorRepository.save(vendor);
	}
	
	@DeleteMapping("/{id}")
	public void deleteVendor(@PathVariable("id") int id) {
		vendorRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Vendor getVendor(@PathVariable("id") int id) {
		return vendorRepository.findById(id).get();
	}
	
}
