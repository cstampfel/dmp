function initChart(categories, series) {
    Highcharts.chart('chart', {
        chart: {
            type: 'line'
        },
        title: {
            text: 'Bevölkerungszahlen'
        },
        xAxis: {
            title: {
                text: 'Jahr'
            },
            categories: categories
        },
        yAxis: {
            title: {
                text: 'Bevölkerungszahl'
            }
        },
        series: series
    });
}

function initTable(data) {
    var items = [];

    items.push("<td></td>");
    for(var i = 0; i < data.series.length; i++) {
        var serie = data.series[i];

        items.push("<td>" + serie.name + "</td>");
    }

    $("#raw-data-header").append(items.join(""));
    items = [];

    for(var i = 0; i < data.categories.length; i++) {
        items.push("<tr>");
        var year = data.categories[i];
        items.push("<td>" + year + "</td>");

        for(var j = 0; j < data.series.length; j++) {
            var dataItem = data.series[j].data[i];

            items.push("<td>" + dataItem + "</td>");
        }
        items.push("</tr>");
    }

    $("#raw-data-body").append(items.join(""));
}

$(function () {
   $.ajax({
      url: "chart/data"
   }).then(function(data) {
       initChart(data.categories, data.series);
       initTable(data);
   });
});