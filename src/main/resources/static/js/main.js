$(function () {
    loadBoxScoreResult();
});

function loadBoxScoreResult(params) {
    $.get("/ajax/box_score_result", params, function (data, textStatus, jqXHR) {
        console.log('textStatus : ' + textStatus);
        console.log('result : ' + JSON.stringify(data));

        if (textStatus == 'success') {

            $('#barChartContainer').highcharts({
                chart: {
                    type: 'bar'
                },
                title: {
                    text: data.title
                },
                xAxis: {
                    categories: data.categories,
                    title: {
                        text: null
                    }
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'Points (pts)',
                        align: 'high'
                    },
                    label: {
                        overflow: 'justify'
                    }
                },
                tooltip :{
                    valueSuffix: ' points'
                },
                plotOptions: {
                    bar: {
                        dataLabels : {
                            enabled : true
                        }
                    }
                },
                legend: {
                    layout: 'veritcal',
                    align: 'right',
                    verticalAlign: 'top',
                    x : -40,
                    y : 80,
                    floating: true,
                    borderWidth: 1,
                    backgroundColor:'#FAFAFA',
                    shadow: true
                },
                credits: {
                    enabled: false
                },
                series: data.series
            });
        }else{
            console.log('unable to retrieve data');
        }
    });
}