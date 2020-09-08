<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

<!-- pagination -->
<script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
<!-- JS, Popper.js, and jQuery -->
<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
<script type="text/javascript">
    $(function () {
        var pageSize = 5; // show 5 records per page (7 rows)
        showPage = function (page) {
            $(".contentPage").hide();
            $(".contentPage").each(function (n) {
                if (n >= pageSize * (page - 1) && n < pageSize * page)
                    $(this).show();
            });
        }
        showPage(1);
        ///** Give value into **///
        var totalRows = ${count}; // total of records
        var btnPage = 2; // numbers of page-number buttons
        var iTotalPages = Math.ceil(totalRows / pageSize);
        var obj = $('#pagination').twbsPagination({
            totalPages: iTotalPages,
            visiblePages: btnPage,
            onPageClick: function (event, page) {
                console.info(page);
                showPage(page);
            }
        });
        console.info(obj.data());
    });
</script>
