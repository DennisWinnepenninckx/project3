<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">-->
    <link href="/static/css/style.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<header>

</header>
<main>
    <div class="row">
    <div class="col-sm-8">
    <article >
        <div class="table-responsive-sm">
            <table class="table table-dark table-bordered">
                <thead>
                <tr>
                    <th>Positie</th>
                    <th>Renner</th>
                    <th>Team</th>
                    <th>Punten</th>
                    <th>Nationaliteit</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>Geraint THOMAS</td>
                    <td>Team Sky</td>
                    <td>83u17'13"</td>
                    <td>Groot-Brittanië</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Tom DUMOULIN</td>
                    <td>Team Sunweb</td>
                    <td>+ 1'51"</td>
                    <td>Nederland</td>
                </tr>


                <tr>
                    <td>3</td>
                    <td>Chris FROOME</td>
                    <td>Team Sky</td>
                    <td>+ 2'24"</td>
                    <td>Groot-Brittanië</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>Primoz ROGLIC</td>
                    <td>Team Lotto NL-Jumbo</td>
                    <td>+ 3'22"</td>
                    <td>Slovenië</td>
                </tr>


                <tr>
                    <td>5</td>
                    <td>Steven KRUIJSWIJK</td>
                    <td> Team Lotto NL-Jumbo</td>
                    <td>+ 6'08"</td>
                    <td>Nederland</td>
                </tr>
                <tr>
                    <td>6</td>
                    <td>Romain BARDET</td>
                    <td>AG2R La Mondiale</td>
                    <td>+ 6'57"</td>
                    <td>Frankrijk</td>
                </tr>


                <tr>
                    <td>7</td>
                    <td>Mikel LANDA MEANA</td>
                    <td>Movistar Team</td>
                    <td>+ 7'37"</td>
                    <td>Spanje</td>
                </tr>
                <tr>
                    <td>8</td>
                    <td>Daniel MARTIN</td>
                    <td>UAE Team Emirates</td>
                    <td> + 9'05"</td>
                    <td>Ierland</td>
                </tr>

                <tr>
                    <td>9</td>
                    <td>Ilnur ZAKARIN</td>
                    <td>Team Katusha Alpecin</td>
                    <td>+ 12'37"</td>
                    <td>Rusland</td>
                </tr>
                <tr>
                    <td>10</td>
                    <td>Nairo QUINTANA</td>
                    <td>Movistar Team</td>
                    <td>+ 14'18"</td>
                    <td>Colombië</td>
                </tr>
                </tbody>
            </table>
        </div>
    </article>
    </div>
    <div class="col-sm-4">
    <aside>
        <p>aside test</p>
    </aside>
    </div>
    </div>
    
    <article>
        <form action="Controller?command=mail" method="post">
            <input type="email" id="receiver" name="receiver">
            <input type="submit">
        </form>
    </article>
</main>
<footer>
    <p>footer</p>
</footer>
</body>
</html>
