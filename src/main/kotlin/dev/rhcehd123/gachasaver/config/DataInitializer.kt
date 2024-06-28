package dev.rhcehd123.gachasaver.config

import dev.rhcehd123.gachasaver.model.entity.Gacha
import dev.rhcehd123.gachasaver.model.entity.GachaItem
import dev.rhcehd123.gachasaver.model.entity.Project
import dev.rhcehd123.gachasaver.repository.GachaItemRepository
import dev.rhcehd123.gachasaver.repository.GachaRepository
import dev.rhcehd123.gachasaver.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class DataInitializer @Autowired constructor(
    private val projectRepository: ProjectRepository,
    private val gachaRepository: GachaRepository,
    private val gachaItemRepository: GachaItemRepository
) : CommandLineRunner {

    @Throws(Exception::class)
    override fun run(vararg arg: String) {
        // Add Sample Game project

        val sampleGameProject = Project()
        val gacha = Gacha()
        val gachaItems: MutableList<GachaItem> = ArrayList()

        sampleGameProject.name = "Sample Game"
        sampleGameProject.apiKey = "RK02ZNvbjtdkJLlhdwqvh7o0Laq14LRrJWPwFjNpALU="
        val gachaList: MutableList<Gacha> = arrayListOf()
        gachaList.add(gacha)
        sampleGameProject.gachaList = gachaList

        gacha.name = "Sample Gacha"
        gacha.project = sampleGameProject
        gacha.gachaItems = gachaItems

        // GachaItem item = new GachaItem();
        // item.setName("A-1");
        // item.setRate("1.500");
        // gachaItems.add(item);
        // item = new GachaItem();
        // item.setName("A-2");
        // item.setRate("1.500");
        // gachaItems.add(item);
        // item = new GachaItem();
        // item.setName("B-1");
        // item.setRate("5.000");
        // gachaItems.add(item);
        // item = new GachaItem();
        // item.setName("B-2");
        // item.setRate("5.000");
        // gachaItems.add(item);
        // item = new GachaItem();
        // item.setName("C-1");
        // item.setRate("43.500");
        // gachaItems.add(item);
        // item = new GachaItem();
        // item.setName("C-2");
        // item.setRate("43.500");
        // gachaItems.add(item);
        gachaItems.add(GachaItem("A-1", "1.500"))
        gachaItems.add(GachaItem("A-2", "1.500"))
        gachaItems.add(GachaItem("B-1", "5.000"))
        gachaItems.add(GachaItem("B-2", "5.000"))
        gachaItems.add(GachaItem("C-1", "43.500"))
        gachaItems.add(GachaItem("C-2", "43.500"))
        gachaItems.forEach(Consumer<GachaItem> { gachaItem: GachaItem ->
            gachaItem.gacha = gacha
        })

        projectRepository.save(sampleGameProject)
        gachaRepository.save(gacha)
        gachaItemRepository.saveAll(gachaItems)
    }
}