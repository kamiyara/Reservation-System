package com.example.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

	private final ResourceService resourceService;

	public ResourceController(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@GetMapping("/resource")
	public ResponseEntity<List<Resource>> getResourceList() {
		return ResponseEntity.ok(resourceService.findAll());
	}

	@PostMapping("/resource")
	public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
		Resource newResource = resourceService.createNewResource(resource);
		if (newResource == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(newResource);
	}

	@DeleteMapping("/resource/{id}")
	public ResponseEntity<List<Resource>> deleteResource(@PathVariable Long id) {
		List<Resource> resources = resourceService.deleteResourceById(id);
		if (resources == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(resources);
	}
}
