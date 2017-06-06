package at.ac.tuwien.dp.datascience.web.rest;

import at.ac.tuwien.dp.datascience.domain.entity.ChartData;
import at.ac.tuwien.dp.datascience.domain.entity.Serie;
import at.ac.tuwien.dp.datascience.domain.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by christoph on 17.05.17.
 */
@Controller
@RequestMapping("/chart")
public class ChartRestfulService {
    @Autowired
    private ChartService chartService;

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    public ChartData chartData() {
        return chartService.getChartData();
    }
}
