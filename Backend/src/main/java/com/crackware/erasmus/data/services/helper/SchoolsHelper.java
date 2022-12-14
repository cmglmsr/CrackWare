package com.crackware.erasmus.data.services.helper;

import com.crackware.erasmus.data.model.DepartmentQuota;
import com.crackware.erasmus.data.model.School;
import com.crackware.erasmus.data.model.enums.Department;
import com.crackware.erasmus.data.repositories.DepartmentQuotaRepository;
import com.crackware.erasmus.data.repositories.SchoolRepository;
import com.crackware.erasmus.data.services.SchoolService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Helper class which handles operations for schools
 */
public class SchoolsHelper {
    private final SchoolService schoolService;

    // Constructor for SchoolsHelper class
    public SchoolsHelper(SchoolService schoolService) {
        this.schoolService = schoolService;
        this.setSchoolRepository();
    }

    // Function which sets new departments and schools
    private HashSet<DepartmentQuota> newSet() {
        DepartmentQuota dqcs = new DepartmentQuota();
        DepartmentQuota dqie = new DepartmentQuota();
        DepartmentQuota dqeee = new DepartmentQuota();
        DepartmentQuota dqme = new DepartmentQuota();
        dqcs.setDepartment(Department.CS);
        dqcs.setQuota(2);
        dqie.setDepartment(Department.IE);
        dqie.setQuota(2);
        dqeee.setDepartment(Department.EE);
        dqeee.setQuota(2);
        dqme.setDepartment(Department.ME);
        dqme.setQuota(2);
        HashSet<DepartmentQuota> s = new HashSet<>();
        s.add(dqcs); s.add(dqeee); s.add(dqie); s.add(dqme);
        return s;
    }

    // Function which returns all schools in the database
    public Set<School> getSchools() {
        return schoolService.findAll();
    }

    // Function which sets a repository for schools
    public boolean setSchoolRepository() {
        // TODO delete quotas, department quotas, schools
        if(!getSchools().isEmpty()) {
            return false;
        }
        School s1 = new School();
        School s2 = new School();
        School s3 = new School();
        School s4 = new School();
        School s5 = new School();
        School s6 = new School();
        School s7 = new School();
        School s8 = new School();
        School s9 = new School();
        School s10 = new School();
        School s11 = new School();
        School s12 = new School();
        School s13 = new School();
        School s14 = new School();
        School s15 = new School();
        s1.setName("Ecole Nationale Superiuere... Carmaux");
        s2.setName("Kingston University");
        s3.setName("Roskilde University");
        s4.setName("Telecom Sud Paris");
        s5.setName("Dortmund TU");
        s6.setName("Technical University of Berlin");
        s7.setName("Vrije Universiteit Amsterdam");
        s8.setName("Ecole Polytechnique Federale de Lausanne");
        s9.setName("Ecole Pour Linformatique Et Les Techniques Avancees (EPITA)");
        s10.setName("AGH University of Science and Technology");
        s11.setName("Saarland University");
        s12.setName("University of L'Aquila");
        s13.setName("Ecole Superieure d'Informatique,Electronique et Automatique(ESIEA)");
        s14.setName("ESIEE Paris");
        s15.setName("Otto Friedrich Universtat Bamberg");

        HashSet<DepartmentQuota> se1 = newSet();
        HashSet<DepartmentQuota> se2 = newSet();
        HashSet<DepartmentQuota> se3 = newSet();
        HashSet<DepartmentQuota> se4 = newSet();
        HashSet<DepartmentQuota> se5 = newSet();
        HashSet<DepartmentQuota> se6 = newSet();
        HashSet<DepartmentQuota> se7 = newSet();
        HashSet<DepartmentQuota> se8 = newSet();
        HashSet<DepartmentQuota> se9 = newSet();
        HashSet<DepartmentQuota> se10 = newSet();
        HashSet<DepartmentQuota> se11 = newSet();
        HashSet<DepartmentQuota> se12 = newSet();
        HashSet<DepartmentQuota> se13 = newSet();
        HashSet<DepartmentQuota> se14 = newSet();
        HashSet<DepartmentQuota> se15 = newSet();

        s1.setDepartmentQuotas(se1);
        s2.setDepartmentQuotas(se2);
        s3.setDepartmentQuotas(se3);
        s4.setDepartmentQuotas(se4);
        s5.setDepartmentQuotas(se5);
        s6.setDepartmentQuotas(se6);
        s7.setDepartmentQuotas(se7);
        s8.setDepartmentQuotas(se8);
        s9.setDepartmentQuotas(se9);
        s10.setDepartmentQuotas(se10);
        s11.setDepartmentQuotas(se11);
        s12.setDepartmentQuotas(se12);
        s13.setDepartmentQuotas(se13);
        s14.setDepartmentQuotas(se14);
        s15.setDepartmentQuotas(se15);

        schoolService.save(s1);
        schoolService.save(s2);
        schoolService.save(s3);
        schoolService.save(s4);
        schoolService.save(s5);
        schoolService.save(s6);
        schoolService.save(s7);
        schoolService.save(s8);
        schoolService.save(s9);
        schoolService.save(s10);
        schoolService.save(s11);
        schoolService.save(s12);
        schoolService.save(s13);
        schoolService.save(s14);
        schoolService.save(s15);
        return true;
    }
}
