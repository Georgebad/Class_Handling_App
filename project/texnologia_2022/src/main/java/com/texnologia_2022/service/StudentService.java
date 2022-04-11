package com.texnologia_2022.service;

import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.texnologia_2022.dao.StudentRepo;
import com.texnologia_2022.entity.Student;


@Service
@Transactional
public class StudentService {
	@Autowired
    private StudentRepo repo;
	
	
	public List<Student> from_course(long id){
		return repo.findByCourse(id);
	} 
    public List<Student> listAllStudents() {
        return repo.findAll();
    }
     
    public void save_student(Student student) {
        repo.save(student);
    }
     
    public Student get_student(long id) {
        return repo.findById(id).get();
    }
     
    public void delete_student(long id) {
        repo.deleteById(id);
    }
    public List<Double> get_grades() {
        return repo.find_grades();
    }
	public DescriptiveStatistics performOperation(List<Double> values) {
		DescriptiveStatistics ds = new DescriptiveStatistics();
		values.forEach(ds::addValue);
		//int windowSize = ds.getWindowSize(); 
		//double max = ds.getMax();
		//double min = ds.getMin();
		//double mean = ds.getMean(); 
		//double median = ds.getPercentile(50);
		//double SD = ds.getStandardDeviation();
		//double variance = ds.getVariance();
		//double skewness = ds.getSkewness();
		//double kurtosis = ds.getKurtosis();
		return ds;
	}
}