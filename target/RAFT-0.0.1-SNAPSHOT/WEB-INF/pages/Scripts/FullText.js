function changeftreviewed() {
    var ret = $('#FTRetrievedFrom option:selected').text();
    $('#divSubscription').hide();
    $('#divPurchase').hide();
    $('#divFulltextURL').show();
    if (ret == 'PDF Viewer') {
        $('#divFulltextURL').hide();
    }
    else if (ret == 'Subscription/Purchased') {
        $('#divSubscription').show();
        $('#divPurchase').show();
    }

}

function changeftreviewedfulfill() {
    var ret = $('#FTRetrievedFromfulfill option:selected').text();
    $('#divSubscriptionfulfill').hide();
    $('#divPurchasefulfill').hide();
    $('#divFulltextURLfulfill').show();
    if (ret == 'PDF Viewer') {
        $('#divFulltextURLfulfill').hide();
    }
    else if (ret == 'Subscription/Purchased') {
        $('#divSubscriptionfulfill').show();
        $('#divPurchasefulfill').show();
    }

}

function changeftreviewedrpt() {
    var ret = $('#FTRetrievedFromrpt option:selected').text();
    $('#divSubscriptionrpt').hide();
    $('#divPurchaserpt').hide();
    $('#divFulltextURLrpt').show();
    if (ret == 'PDF Viewer') {
        $('#divFulltextURLrpt').hide();
    }
    else if (ret == 'Subscription/Purchased') {
        $('#divSubscriptionfulfill').show();
        $('#divSubscriptionrpt').show();
    }

}

function enableMenus() {
    var menus = sessionlist;
    $("#Requester").prop("disabled", true);
    $("#Fulfiller").prop("disabled", true);
    $("#Reports").prop("disabled", true);

    if (menus.includes(',')) {
        if (menus.endsWith(',')) {
            menus.slice(0, -1);
        }
        var menuitem = menus.split(',');

        if (menuitem.includes('Full Text Requests Report')) {
            $("#Reports").prop("disabled", false);
            $("#Reports").click();
        }

        if (menuitem.includes('Full Text FullFiller')) {
            $("#Fulfiller").prop("disabled", false);
            $("#Fulfiller").click();
        }

        if (menuitem.includes('Full Text Request')) {
            $("#Requester").prop("disabled", false);
            $("#Requester").click();
        }

    }
    else if (menus == 'admin') {
        $("#Requester").prop("disabled", false);
        $("#Fulfiller").prop("disabled", false);
        $("#Reports").prop("disabled", false);
        //$("#Requester").click();
        //$("#Fulfiller").click();
        $("#Reports").click();
    }
}

function showMenus() {
    var menus = sessionlist;
    if (menus == 'admin') {
        menus = 'Full Text Request,Full Text FullFiller,Full Text Requests Report';
    }
    if (menus.includes(',')) {
        if (menus.endsWith(',')) {
            menus.slice(0, -1);
        }
        var menuitem = menus.split(',');

        if (menuitem.includes('Full Text Requests Report')) {
            $("#Reports").show();
            $("#Reports").prop("disabled", false);
            $("#Reports").click();
        }

        if (menuitem.includes('Full Text FullFiller')) {
            $("#Fulfiller").show();
            $("#Fulfiller").prop("disabled", false);
            $("#Fulfiller").click();
        }

        if (menuitem.includes('Full Text Request')) {
            $("#Requester").show();
            $("#Requester").prop("disabled", false);
            $("#Requester").click();
        }

    }

    if (menuitem.includes('Full Text Request')) {
        $("#Requester").show();
        $("#Requester").prop("disabled", false);
        $("#Requester").click();
    }

    //else if (menus == 'admin') {

    //    $("#Requester").show();
    //    $("#Fulfiller").show();
    //    $("#Reports").show();
    //    $("#Requester").prop("disabled", false);
    //    $("#Fulfiller").prop("disabled", false);
    //    $("#Reports").prop("disabled", false);
    //    $("#Requester").click();
    //}
    //$("#Requester").prop("disabled", true)
}

//Anil Added on 20200128 
function IsBulkRequest() {
    var pmid = $('#pmid').val();
    //20200118 Anil added to not to check if semicolon exists    //!pmid.includes(';')
    var hdnpmid = $('#hdnpmid').val();
    //alert(hdnpmid);
    if (pmid != '' && pmid.includes(';')) {
        $('#btnsearch').hide();
      //  $('#btnbulkrequest').show();
        $('#btnAdd').html('Bulk Request Full Text');
    }
    else {
        $('#btnsearch').show();
        $('#btnAdd').html('Request Full Text');
       // $('#btnbulkrequest').hide();
    }
}

function IsBulkRequests() {
    var pmid = $('#pmid').val();
    //20200118 Anil added to not to check if semicolon exists    //!pmid.includes(';')
    var hdnpmid = $('#hdnpmid').val();
    //alert(hdnpmid);
    if (pmid != '' && pmid.includes(';')) {
        $('#btnsearch').attr("disabled", true);
        //  $('#btnbulkrequest').show();
        $('#btnAdd').html('Bulk Request Full Text');
    }
    else {
        $('#btnsearch').attr("disabled", false);
        $('#btnAdd').html('Request Full Text');
        // $('#btnbulkrequest').hide();
    }
}
//20200211
function setSearchType() {
    $('#Requester').on('click', function () {
        pageName = "FullTextRequest";
       // $("#search").show();
        //Clear();
        //SavesearchRequest();
    });
    $('#Fulfiller').on('click', function () {
        pageName = "FullTextFullFiller";
       // $("#Fulfill").show();
        //ClearFilters();
        //GetSearchFulfiller();
    });
    $('#Reports').on('click', function () {
        pageName = "Report";
      //  $("#Report").show()
       // $('#btnReport').click();
        //GetReportDetailsNew(); 
    });
    
}

function ClearFilters() {
    $('#Statusfulfiller').val('4');
    $('#Priorityfulfiller').val('-1');
    $('#pmidfulfiller').val('');
    $('#Usernamefulfiller').val('-1');
    $('#Fromfulfiller').val('');
    $('#Tofulfiller').val('');
    $('#FTRetrievedFromfulfiller').val('-1');
    //var table = $('#fulfillDataTable').DataTable();
    //table.Clear();
    //$('#fulfillDataTable').Clear();

}
function ClearFulfiller() {
    
    $('#Statusfulfill').val('-1');
    $('#FTRetrievedFromfulfill').val('-1');
    $('#divFulltextURLfulfill').show();
    $('#divSubscriptionfulfill').hide();
    $('#divPurchasefulfill').hide();
    $('#Notesfulfill').val('');
    $('#FulltextFilefulfill').val('');
    $('#SupplementMaterialfulfill').val('');
    $('#FulltextURLfulfill').val('');
    $('#pubmedURLfulfill').val('');
    $('#EhostURLfulfill').val('');
    
    $("input[name='optradio']").each(function () {
        $(this).prop('checked', false);
    });
    $('#Costfulfill').val('');
    $('#AutoRenewalURLfulfill').val('');
    $("input[name='AutoRenewalfulfill']")[0].checked = false;
    $('#errorMessagefulfill').html('');
    $('#statusMessagefulfill').html('');
    $('#errorMessagefulfill').hide();
    $('#statusMessagefulfill').hide();

    //changeftreviewed();
    changeftreviewedfulfill();
    var file1 = $("#divPurchaseFile").find('input');
    if (file1)
        $("#divPurchaseFile").find('input').val('');
    var file2 = $("#divFullTextFile").find('input');
    if (file2)
        $("#divFullTextFile").find('input').val('');


    $("#lblpurchasefilenames").val('');
    $("#lblFTfilenames").val('');

    
}


function Clear() {
    if (pageName == "FullTextRequest") {
        $('#btnAdd').html('Request Full Text');
        $('#btnAdd').attr("disabled", false);
        $('#hdnpmid').val('');
        $('#hdnreqid').val('');
        $('#hdntitle').val('');
        $('#pmid').val('');
        $('#title').val('');
        $('#journaltitle').val('');
        $('#Citation').val('');
        $('#Instructions').val('');
        $('#Priority').val('0');
        $('#CostCenter').val('-1');
        
        if (costcentersession != '') {
            $('#CostCenter').val(costcentersession);
        }
        else {
            $('#CostCenter').val('-1');
        }

        $('#statusMessage').html('');
        //$('#errorMessage').html('');
        //$('#errorMessage').hide();
        $('#statusMessage').hide();
        $('#divNESID').hide();
        $('#divRequestedBy').hide();
        $('#divRequestedOn').hide();
        $('#Status').val('-1');
        $('#FTRetrievedFrom').val('-1');
        $('#divFulltextURL').show();
        $('#divSubscription').hide();
        $('#divPurchase').hide();
        $('#Notes').val('');

        $('#FulltextURL').val('');
        $('#NESID').val('');
        $('#RequestedBy').val('');
        $('#RequestedOn').val('');
        $("input[name='optradio']").each(function () {
            $(this).prop('checked', false);
        });
        $('#Cost').val('');
        $('#AutoRenewalURL').val('');
        $("input[name='autourl']")[0].checked = false;
        $('#pubmedURL').val(''); //20191218
        $('#EhostURL').val('');
        $('#FreeFTURL').val('');
        
        //$("#loader").hide();
    }
}

function clearReportfilter() {
    $('#Statusfrpt').val('4');
    $('#Priorityfrpt').val('-1');
    $('#CostCenterfrpt').val('-1');
    $('#pmidfrpt').val('');
    $('#Usernamefrpt').val('');
    $('#From').val('');
    $('#To').val('');
    $("input[name='slamrecords']")[0].checked = false;
    ClearRpt();
}

function ClearRpt() {
    
        $('#hdnreqidrpt').val('');
        $('#pmidrpt').val('');
        $('#titlerpt').val('');
        $('#journaltitlerpt').val('');
        $('#Citationrpt').val('');
        $('#Instructionsrpt').val('');
        $('#Priorityrpt').val('-1');
        $('#FTRetrievedFromrpt').val('-1');
        $('#divFulltextURLrpt').show();
        $('#divSubscriptionrpt').hide();
        $('#divPurchaserpt').hide();
        $('#Notesrpt').val('');
        $('#FulltextFilerpt').val('');
        $('#SupplementMaterialrpt').val('');
        $('#FulltextURLrpt').val('');
        $('#NESIDrpt').val('');
        $('#RequestedByrpt').val('');
        $('#RequestedOnrpt').val('');

        $('#pubmedURLrpt').val('');
        $('#EhostURLrpt').val('');

        $("input[name='optradio']").each(function () {
            $(this).prop('checked', false);
        });
        $('#Costrpt').val('');
        $('#AutoRenewalURLrpt').val('');
        $("input[name='autourl']")[0].checked = false;
        $('#statusMessage').html('');
        //$('#errorMessage').html('');
        //$('#errorMessage').hide();
        $('#statusMessage').hide();
      
        $('#lblFTfilenamesrpt').val('');
        $('#lblpurchasefilenamesrpt').val('');
        $('#perecent').html('');
        $('#progress').val('0');
} 

function DeleteRequest(reqId) {
    $('#statusMessage').html('');
    $('#errorMessage').html('');
    var hdnreqid = $('#hdnreqid').val();
    if (hdnreqid == '') {
        alert('Request ID must not be empty. Please select the record');
        return false;
    }

    $.ajax({
        type: "POST",
        url: "FullPageRequestService.asmx/DeleteRequest", 
        data: {
            requestId: reqId,
            deletedBy: sessionusername,
            deletedFrom: pageName
        },
        async: true,
        error: function (xhr, ajaxOptions, thrownError) {
            if (xhr.status == "200") {
                Clear();
                ClearFilters();
                //GetSearchRequest();
                GetSearchRequest_New();
                $('#statusMessage').html('Data deleted successfully!');
                $('#statusMessage').show();
            }
            else {

                //for debugging 
                //alert(xhr.status);
                //alert(xhr.responseText);
                //alert(thrownError);

                $('#errorMessage').html('Data not deleted!');
                $('#errorMessage').show();
            }
        },
        success: function (msg) {
            // alert('Success');
            Clear();
            ClearFilters();
            //GetSearchRequest();
            GetSearchRequest_New();

            $('#statusMessage').html('Data deleted successfully!');
            $('#statusMessage').show();
        }
    });
}

function CommitRequest() {

    $('#statusMessage').html('');
    $('#errorMessage').html('');

    if (!confirm('Are you sure want to commit the request?')) {
        return false;
    }
    var hdnreqid = $('#hdnreqid').val();
    if (hdnreqid == '') {
        alert('Request ID must not be empty');
    }
    $.ajax({
        type: "POST",
        url: "FullPageRequestService.asmx/CommitRequest",
        data: {
            requestId: hdnreqid,
            requestFrom: pageName,
            userID: sessionUserID
        },
        dataType: "json",
        async: true,
        error: function (xhr, ajaxOptions, thrownError) {
            if (xhr.status == "200") {
                //Clear();
                //GetSearchRequest();
                GetSearchRequest_New();

                $('#statusMessage').html('Request Committed!');
                $('#statusMessage').show();
            }
            else {
                //for degugging
                //alert(xhr.status);
                //alert(xhr.responseText);
                //alert(thrownError);

                $('#errorMessage').html('Data not saved!');
                $('#errorMessage').show();
            }
        },
        success: function (msg) {
            //Clear();
            //GetSearchRequest();
            GetSearchRequest_New();
            $('#statusMessage').html('Request Committed!');
            $('#statusMessage').show();
        }
    });
}
function CheckPMIDExist() {
    $('#statusMessage').html('');
    $('#errorMessage').html('');
    var pmid = $('#pmid1').val();
    //20200118 Anil added to not to check if semicolon exists    //!pmid.includes(';')
    var hdnpmid = $('#hdnpmid').val();
    //alert(hdnpmid);
    if (pmid != '' && !pmid.includes(',')) {
        $.ajax({
            async: true,
            type: "GET",
            url: "FullPageRequestService.asmx/PMIDExist",
            data: {
                PMID: pmid.trim(),
                RequestID: '',
            },
            dataType: "json",
            error: function (xhr, ajaxOptions, thrownError) {

                //for debugging
                //alert(xhr.status);
                //alert(xhr.responseText);
                //alert(thrownError);

                alert('Error while checking PMID is exists or not');
            },
            success: function (data) {
                //alert(data);
                if (data == 'exist' && hdnpmid != pmid) {
                    $('#errorMessage').html('Existing request available !');
                    $('#errorMessage').show();
                    $('#pmid1').val(pmid);
                    //$('#Username').val('0');
                    $("#Username option").each(function () {
                        if ($(this).text() == 'AllUsers') {
                            $(this).prop('selected', true);
                        }
                    });
                    //alert('Please check existing PMID details above table panel');
                    //GetSearchRequest();
                    //GetSearchRequest_New();

                }
            }
        });
    }
}

function CheckPMIDExistsingle() {
    $('#statusMessage').html('');
    $('#errorMessage').html('');
    var pmid = $('#pmid').val();
    //20200118 Anil added to not to check if semicolon exists    //!pmid.includes(';')
    var hdnpmid = $('#hdnpmid').val();
    //alert(hdnpmid);
    if (pmid != '' && !pmid.includes(';')) {
        $.ajax({
            async: true,
            type: "GET",
            url: "FullPageRequestService.asmx/PMIDExist",
            data: {
                PMID: pmid.trim(),
                RequestID: '',
            },
            dataType: "json",
            error: function (xhr, ajaxOptions, thrownError) {

                //for debugging
                //alert(xhr.status);
                //alert(xhr.responseText);
                //alert(thrownError);

                alert('Error while checking PMID is exists or not');
            },
            success: function (data) {
                //alert(data);
                if (data == 'exist' && hdnpmid != pmid) {
                    $('#errorMessage').html('Existing request available !');
                    $('#errorMessage').show();
                    $('#pmid').val(pmid);
                    //$('#Username').val('0');
                    $("#Username option").each(function () {
                        if ($(this).text() == 'AllUsers') {
                            $(this).prop('selected', true);
                        }
                    });
                    //alert('Please check existing PMID details above table panel');
                    //GetSearchRequest();
                    //GetSearchRequest_New();

                }
            }
        });
    }
}

// in use
function SaveRequest() {
    var pmid = $('#pmid').val();

    if (!pmid.includes(',')) {
        SaveRequestInformation();
    }
}

//20200316

function ReopenRequest() {

    $('#statusMessage').html('');
    $('#errorMessage').html('');
    $('#errorMessage').hide();
    var pmid = $('#pmid').val();
    var hdnpmid = $('#hdnpmid').val();
    var hdnreqid = $('#hdnreqid').val();
    var hdntitle = $('#hdntitle').val();
    var Prioritytext = $('#Priority option:selected').text();
    if (Prioritytext == '--select--') {
        alert('Select Priority');
        return false;
    }


    var CostCenter = $('#CostCenter option:selected').text();
    if (CostCenter == '--select--') {
        CostCenter = '';
        //alert('Select Cost Center');
        //return false;
    }


    var title = $('#title').val();
    if (pmid == '') {
        alert('PMID must not be empty');
        return false;
    }
   
    pmid = pmid.trim();
    title = title.trim();
    var request = {
        RequestID: hdnreqid,
        PMID: pmid,
        Title: title,
        JournalTitle: $('#journaltitle').val().trim(),
        Citation: $('#Citation').val().trim(),
        Instructions: $('#Instructions').val().trim(),
        Priority: Prioritytext,
        RequestedBy: sessionusername,
        RequestFrom: "FullTextRequest",
        PubMedFTURL: $('#pubmedURL').val().trim(),
        EhostFTLink: $('#EhostURL').val().trim(),
        CostCenter: CostCenter
    };
    $.ajax({
        type: "POST",
        url: "FullPageRequestService.asmx/ReopenRequest",
        data: "{'request':" + JSON.stringify(request) + "}",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        async: true,
        success: function (data) {

            // Clear();
            $('#divNESID').hide();
            $('#divRequestedBy').hide();
            $('#divRequestedOn').hide();
            // ClearFilters();
            //GetSearchRequest();
            //GetSearchRequest_New();
         
            $("#btnReopenRequest").hide();
            //$("#btnReopenRequest").css({ marginLeft: '20%' });//works
            $("#btnAdd").css({ marginLeft: '20%' });

            $('#statusMessage').html('Request has been Reopened');
            $('#btnAdd').html('Save Changes');
            $('#errorMessage').html('');
            $('#statusMessage').show();
            GetSearchRequestSave();
            // $("#searchcard").animate({ scrollTop: 500 }, "slow");
            $("#searchcard").animate({ scrollTop: 0 }, "slow");
        },
        error: function (xhr, ajaxOptions, thrownError) {

            //alert(xhr.status);
            alert(xhr.responseText);
            //alert(thrownError);
            $('#errorMessage').html('Data not saved!');
            $('#errorMessage').show();
        }

    });
}

// in use
function SaveRequestInformation() {

    $('#statusMessage').html('');
    $('#errorMessage').html('');
    $('#errorMessage').hide();
    var pmid = $('#pmid').val();
    var hdnpmid = $('#hdnpmid').val();
    var hdnreqid = $('#hdnreqid').val();
    var hdntitle = $('#hdntitle').val();
    var Prioritytext = $('#Priority option:selected').text();
    if (Prioritytext == '--select--') {
        alert('Select Priority');
        return false;
    }

    
    var CostCenter = $('#CostCenter option:selected').text();
    if (CostCenter == '--select--') {
        alert('Select Cost Center');
        return false;
    }

    var FTRetrievedFrom = $('#FTRetrievedFrom option:selected').text();
    if (FTRetrievedFrom == '--select--') {
        FTRetrievedFrom = '';
    }

    var title = $('#title').val();
    if (pmid == '') {
        alert('PMID must not be empty');
        return false;
    }
    if (hdnpmid.trim() != pmid.trim() && title!='') {
        if (hdntitle.trim() == title.trim()) {
            alert('PMID has been changed but Title is not yet changed. \n\nTitle should not be equal for two different PMIDs');
            return false;
        }
    }

    pmid = pmid.trim();
    title = title.trim();
    var request = {
        RequestID: hdnreqid,
        PMID: pmid,
        Title: title,
        JournalTitle: $('#journaltitle').val().trim(),
        Citation: $('#Citation').val().trim(),
        Instructions: $('#Instructions').val().trim(),
        Priority: Prioritytext,
        RequestedBy: sessionusername,
        RequestFrom: "FullTextRequest",
        PubMedFTURL: $('#pubmedURL').val().trim(),
        EhostFTLink: $('#EhostURL').val().trim(),
        CostCenter: CostCenter,
        FulltextUrl: $('#hdnFTUrl').val().trim(),
        FTRetrievedFrom: FTRetrievedFrom
    };
    $.ajax({
        type: "POST",
        url: "FullPageRequestService.asmx/SaveRequest",
        data: "{'request':" + JSON.stringify(request) + "}",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        async: true,
        success: function (data) {
            //20200415
            sethdnfieldsAfterSave(); //Sets hidden values to check for  any modifications
        // Clear();
            $('#divNESID').hide();
            $('#divRequestedBy').hide();
            $('#divRequestedOn').hide();
           // ClearFilters();
            //GetSearchRequest();
            //GetSearchRequest_New();
            GetSearchRequestSave();
            if (hdnreqid == '') {
                $('#statusMessage').html('Full text request has been submitted');
            }
            else {
                $('#statusMessage').html('Full text request has been updated');
            }

            if ($('#btnAdd').html() == 'Save Changes') {
                $('#errorMessage').html('');
                $('#statusMessage').html('Data updated successfully!');
            }

            //if ($('#btnAdd').html('Save Changes')) {
            //    $('#statusMessage').html('Request has been submitted!');
            //}

            if ($('#btnAdd').html() =='Request Full text') {
                $('#statusMessage').html('Full text request has been submitted');
            }

            if ($('#btnAdd').html() =='Open Free Full Text') {
                //$('#statusMessage').html('Link Opened – PDF will be attached to request');
                //20200413
                //var freemsg = 'Link Opened &#8212 PDF will be attached to request'
                $('#statusMessage').html('Link Opened &#8211; PDF will be attached to request').text();
                    

                //20200326
                var pubmed = $("#pubmedURL").val();
                if (pubmed.length > 0) {
                    window.open(pubmed, '_blank');
                }

                var ehostURL = $("#EhostURL").val();
                if (ehostURL.length > 0) {
                    window.open(ehostURL, '_blank');
                }

                var fulltextUrl = $("#FulltextURL").val();
                if (fulltextUrl.length > 0) {
                    window.open(fulltextUrl, '_blank');
                }

            }

            $('#btnAdd').html('Save Changes');
            $('#errorMessage').html('');
            $('#statusMessage').show();

            //20200415 to disable save button and Enable if any data modifications are done
            $('#btnAdd').attr("disabled", true);
            $('#btnAdd').removeClass("btn btn-success").addClass("btn btn-secondary");
             $('#hdnsavebtn').attr("disabled", false);
                    

            $("#searchcard").animate({ scrollTop: 0 }, "slow");

        },
        error: function (xhr, ajaxOptions, thrownError) {

            //alert(xhr.status);
            alert(xhr.responseText);
            //alert(thrownError);
            $('#errorMessage').html('Data not saved!');
            $('#errorMessage').show();
        }

    });
}

//20200325 // in use
function SavesearchRequest() {
    $('#divRequestInfo').hide();
    $('#hdnalertmsg').val('');
    var pmid = $('#pmid1').val();

    if (pmid.includes(';;')) {
        while (pmid.includes(';;')) {
            pmid = pmid.replace(';;', ',');
        }

        $('#pmid1').val(pmid);
    }
    if (pmid.includes(',,')) {
        while (pmid.includes(',,')) {
            pmid = pmid.replace(',,', ',');
        }

        $('#pmid1').val(pmid);
    }

    if (pmid.includes(',')) {
        while (pmid.charAt(0) === ',') {
            pmid = pmid.substr(1);
        }

        $('#pmid1').val(pmid);
    }

    if (pmid.endsWith(","))
    {
        while (pmid.endsWith(",")) {
            pmid = pmid.slice(0, -1);
        }
        $('#pmid1').val(pmid);
    }

    pmid = pmid.trim();

    while (pmid.includes('  ')) {
        pmid = pmid.replace('  ', ' ');
    }

    while (pmid.includes(' ')) {
        pmid = pmid.replace(' ', ',');
    }

    while (pmid.includes('\t')) {
        pmid = pmid.replace('\t', ',');
    }


    if (pmid != '') {
        if (pmid.includes(',') || pmid.includes(' ')) {
            
            while (pmid.includes(' ')) {
                pmid = pmid.replace(' ', ',');
            }

            while (pmid.includes(',,')) {
                pmid = pmid.replace(',,', ',');
            }

            while (pmid.includes(',,')) {
                pmid = pmid.replace(',,', ',');
            }
          

            pmid = pmid.replace(',,', ',');

            if (pmid.includes(',')) {
                var pmids = pmid.split(",");

                
            }

            if (pmids.length <= 20) {
                SendBulkRequests(pmid);
            }
            else {

                alert("You can save upto 20 requests only");
            }

        }
        else { //20200120 Anil Added Single request
            if (pmid != '' && pmid != null) {
                GetDatapmid();
                //var isExpandedh = $('#heading-example').attr("aria-expanded");
                //if (isExpandedh == 'true') {
                //    $('#heading-example').click();
                //} // 20200319 Commented by Anil, not to collapse Requests div

                var isExpandedi = $('#heading-example1').attr("aria-expanded");
                if (isExpandedi == 'false') {
                    $('#heading-example1').click();
                }
            }
        }
    }
    else {
        alert("Enter valid PMID(s)");
    }
}

function CheckPMIDExist_Search(searchpmid) {
    $('#statusMessage').html('');
    $('#errorMessage').html('');

    var pmid = JSON.stringify({ pmid: searchpmid });
    
    
    if (pmid != '' && !pmid.includes(';')) {
        $.ajax({
            type: "POST",
            url: "FullPageRequestService.asmx/CheckStatusPMID",
            data: pmid,
            async: false,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                //alert(JSON.stringify(data));
                if (data.d == '') {
                    //alert('Has to be Saved');
                    SearchandSaveRequestInformation_New(searchpmid);
                }
                else {
                    
                    var alertstr = 'PMID:' + searchpmid + " - " + data.d;
                    $('#hdnalertmsg').val( $('#hdnalertmsg').val() + '\n' + alertstr);
                    //alert(alertstr);
                    
                }

               
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert('Error while checking PMID is exists or not');
            }
        });
    }
}

function SearchandSaveRequestInformation() {

    $('#statusMessage').html('');
    $('#errorMessage').html('');

    var pmid = $('#pmid1').val();
    var hdnpmid = $('#hdnpmid').val();
    var hdnreqid = $('#hdnreqid').val();
    var hdntitle = $('#hdntitle').val();
    var Prioritytext = $('#Priority option:selected').text();
    if (Prioritytext == '--select--')
        Prioritytext = '';
    var title = $('#title').val();
   
    pmid = pmid.trim();
    title = title.trim();
    if (pmid != '') {
        var request = {
            RequestID: hdnreqid,
            PMID: pmid,
            Title: title,
            JournalTitle: $('#journaltitle').val().trim(),
            Citation: $('#Citation').val().trim(),
            Instructions: $('#Instructions').val().trim(),
            Priority: Prioritytext,
            RequestedBy: sessionusername,
            RequestFrom: "FullTextRequest",
            PubMedFTURL: $('#pubmedURL').val().trim(),
            EhostFTLink: $('#EhostURL').val().trim(),
        };
        $.ajax({
            type: "POST",
            url: "FullPageRequestService.asmx/SearchandSaveRequest",
            data: "{'request':" + JSON.stringify(request) + "}",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: true,
            success: function (data) {

                alert(data.d);
                Clear();
               // ClearFilters();
                //GetSearchRequest();
                GetSearchRequest_New();
                $('#divRequestInfo').hide();
                //alert('Your request(s) is/are successful!');
                //if (hdnreqid == '') {
                //    $('#statusMessage').html('Data inserted successfully!');
                //}
                //else {
                //    $('#statusMessage').html('Data updated successfully!');
                //}

                if ($('#btnAdd').html() =='Save Changes') {
                    $('#statusMessage').html('Request has been submitted!');
                }

                if ($('#btnAdd').html() == 'Request Full text') {
                    $('#statusMessage').html('Request has been submitted!');
                }
                if ($('#btnAdd').html() == 'Open Free Full Text') {
                    $('#statusMessage').html('Request has been Fulfilled!');
                }

                $('#btnAdd').html('Request Full text');

                $('#statusMessage').show();

            },
            error: function (xhr, ajaxOptions, thrownError) {

                //alert(xhr.status);
                alert(xhr.responseText);
                //alert(thrownError);
                $('#errorMessage').html('Data not saved!');
                $('#errorMessage').show();
            }

        });

    }
}

function SearchandSaveRequestInformation_New(pmid) {

    $('#statusMessage').html('');
    $('#errorMessage').html('');
    var hdnreqid = $('#hdnreqid').val();
    var Prioritytext = $('#Priority option:selected').text();
    if (Prioritytext == '--select--')
        Prioritytext = '';
    var title = $('#title').val();

    pmid = pmid.trim();
    title = title.trim();
    if (pmid != '') {
        var request = {
            RequestID: hdnreqid,
            PMID: pmid,
            Title: title,
            JournalTitle: $('#journaltitle').val().trim(),
            Citation: $('#Citation').val().trim(),
            Instructions: $('#Instructions').val().trim(),
            Priority: Prioritytext,
            RequestedBy: sessionusername,
            RequestFrom: "FullTextRequest",
            PubMedFTURL: $('#pubmedURL').val().trim(),
            EhostFTLink: $('#EhostURL').val().trim(),
        };
        $.ajax({
            type: "POST",
            // url: "FullPageRequestService.asmx/SearchandSaveRequest", //SearchandSaveEachRequest
            url: "FullPageRequestService.asmx/SearchandSaveEachRequest", //
            data: "{'request':" + JSON.stringify(request) + "}",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: true,
            success: function (data) {
             //   Clear();
                $('#divRequestInfo').hide();
                var alertmsg = 'PMID:' + pmid + ' - ' + ' request has been submitted successfully';
                //alert(alertmsg);
                //hdnalertmsg = hdnalertmsg + '\n' + alertmsg;
                var nmsg = $('#hdnalertmsg').val() + '\n' + alertmsg
                $('#hdnalertmsg').val(nmsg);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                //alert(xhr.status);
                alert(xhr.responseText);
                //alert(thrownError);
                $('#errorMessage').html('Data not saved!');
                $('#errorMessage').show();
            }

        });

    }
}

// in use
function SaveFulfil() {
    var optradio = '';
    if ($("input[name='optradiofulfill']:checked"))
        optradio = $("input[name='optradiofulfill']:checked").parent('label').text().trim();
    var autourl = false;
    if ($("input[name='AutoRenewalfulfill']:checked").length > 0)
        autourl = $("input[name='AutoRenewalfulfill']:checked")[0].checked;

    var pmid = $('#pmidfulfiller1').val();
    var hdnreqid = $('#hdnreqid').val();
    if (pmid == '') {
        alert('PMID must not be empty');
        return false;
    }
    if (hdnreqid == '') {
        alert('Request ID must not be empty');
        return false;
    }

    var CostCenterfulfill = $('#CostCenterfulfill option:selected').text();
    if (CostCenterfulfill == '--select--')
        CostCenterfulfill = '';
   
    var statustext = $('#Statusfulfill option:selected').text();
    if (statustext == '--select--')
        statustext = '';

    var FulltextURLfulfill = $('#FulltextURLfulfill').val();
    
    var FTRetrievedFrom = $('#FTRetrievedFromfulfill option:selected').text();
    if (FTRetrievedFrom == '--select--')
        FTRetrievedFrom = '';

    if (statustext == '') {
        alert('Select Status');
        return false;
    }

    if (statustext == 'Fulfilled' && CostCenterfulfill == '') {
        alert('Select Cost Center');
        return false;
    }
    
    if (FTRetrievedFrom == '') {
        alert('Select FT Retrieved From');
        return false;
    }
        
    if (FTRetrievedFrom == 'Science Direct' || FTRetrievedFrom == 'PubMed' || FTRetrievedFrom == 'Free Downloads') {

        if (FulltextURLfulfill == '') {
            alert('Please Enter Full-text URL');
            return false;
        }
    }

    if (FTRetrievedFrom == 'Subscription/Purchased') {

        if (optradio.trim() == '') {
            alert('Please select Purchase or Subscription radio box');
            return false;
        }
        var lblpurchasefilenames = $('#lblpurchasefilenames').html();
        if (lblpurchasefilenames.trim() == '') {
            alert('Please upload Purchase Receipt file');
            return false;
        }
    }


    var request = {
        pmidfulfiller1:pmid,
        RequestIDfulfill: hdnreqid,
        ReviewedByfulfill: sessionusername,
        Statusfulfill: statustext,
        FTRetrievedFromfulfill: FTRetrievedFrom,
        FulltextURLfulfill: $('#FulltextURLfulfill').val(),
        Notesfulfill: $('#Notesfulfill').val(),
        RequestFromfulfill: "FullTextFullFiller",
        FulltextFilefulfill: '',
        SupplementMaterialfulfill: '',
        PurchaseorSubscriptionTypefulfill: optradio,
        Costfulfill: $('#Costfulfill').val(),
        AutoRenewalURLfulfill: $('#AutoRenewalURLfulfill').val(),
        AutoRenewalfulfill: autourl,
        CostCenterfulfill: CostCenterfulfill
    };
    $.ajax({
        type: "POST",
        url: "FullPageRequestService.asmx/SaveFulfillRequest",
        data: "{'request': " + JSON.stringify(request) + "}",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        async: true,
        error: function (xhr, ajaxOptions, thrownError) {
            alert(xhr.status);
            alert(xhr.responseText);
            alert(thrownError);
            $('#errorMessage').html('Data not saved!');
            $('#errorMessage').show();
        },
        success: function (msg) {
            // alert('Success');
            //Clear();
            //GetSearchRequest();
            //GetSearchRequest_New();
            GetSearchFulfiller();
            $('#statusMessagefulfill').html('Submission Successful');
            $('#statusMessagefulfill').show();
        }
    });
}

function now() {
    var todaydate = new Date();
    var day = todaydate.now();
    var month = todaydate.getMonth() + 1;
    var year = todaydate.getFullYear();
    var datestring = year + "-" + month + "-" + day;
    if ($('#From').length <= 0) {
        $('#From').val(datestring);
    }
    if ($('#To').length <= 0) {
        $('#To').val(datestring);
    }
} 


function dateFormatfulfill() {
    if ($('#Fromfulfiller').length > 0) {
        $('#Fromfulfiller').datepicker({
            format: 'yyyy-mm-dd',
           // startDate: '-3d',
            uiLibrary: 'bootstrap4', size: 'small',
            iconsLibrary:'fontawesome',
            width: 100,
            autoclose: true,
            endDate: '+d',
            todayHighlight: true
            
        });
    }

    if ($('#Tofulfiller').length > 0) {
        $('#Tofulfiller').datepicker({
            format: 'yyyy-mm-dd',
           // startDate: '-3d',
            uiLibrary: 'bootstrap4', size: 'small',
            iconsLibrary: 'fontawesome',
            width: 100,
            autoclose: true,
            endDate: '+d',
            todayHighlight: true,
           
        });
    }
}

function dateFormat() {
    if ($('#From').length > 0) {
        $('#From').datepicker({
            format: 'yyyy-mm-dd',
          //  startDate: '-3d',
            uiLibrary: 'bootstrap4', size: 'small',
            iconsLibrary: 'fontawesome',
            width: 100,
            autoclose: true,
            endDate: '+d',
            todayHighlight: true,
            //onSelect: function (selected) {
            //    $("#To").datepicker("option", "minDate", selected)
            //}
        });
    }
   
    if ($('#To').length > 0) {
        $('#To').datepicker({
            format: 'yyyy-mm-dd',
           // startDate: '-3d',
            uiLibrary: 'bootstrap4', size: 'small',
            iconsLibrary: 'fontawesome',
            width: 100,
            autoclose: true,
            endDate: '+d',
            todayHighlight: true,
            //onSelect: function (selected) {
            //    $("#From").datepicker("option", "maxDate", selected)
            //}
        });
    }
}

function DOINavigation() {
    $("#btnDOICheck").click(function () {
        var citation = '';
        var doiregex = '';
        var doi = '';


        citation = $("#Citation").val();
        doiregex = /\s+10\..*?\s+/g;
        doi = citation.match(doiregex);
        if (!doi) {
            doiregex = /\s+10\..*\.$/g;
            doi = citation.match(doiregex);
        }
        if (!doi) {
            doiregex = /\s+10\..*$/g;
            doi = citation.match(doiregex);
        }
        if (!doi) {
            doiregex = /^10\..*\s+/g;
            doi = citation.match(doiregex);
        }
        if (!doi) {
            doiregex = /^10\..*\.$/g;
            doi = citation.match(doiregex);
        }
        if (!doi) {
            doiregex = /^10\..*$/g;
            doi = citation.match(doiregex);
        }
        if (doi == '') {
            alert('DOI is not available in given citation');
            return false;
        }
        if (doi) {
            var doiData = doi.toString();
            doiData = doiData.trim();
            doiData = doiData.replace(/\.$/g, "");
            doiData = doiData.replace(/\s+$/g, "");
            if (doiData == '') {
                alert('DOI is not available in given citation');
                return false;
            }
            doiData = 'https://dx.doi.org/' + doiData;
            window.open(doiData, '_blank');
            //alert(doi);
        }
       else {
            alert('DOI is not available in given citation');
            return false;
        }


        return false;
    });
}

function openPubMedUrl() { 
    $("#pubmedURL").click(function () {
        var pubmed = $("#pubmedURL").val();
        if (pubmed.length > 0) {
            window.open(pubmed, '_blank');
        }
        return false;
    });

    $("#pubmedURLfulfill").click(function () {
        var pubmed = $("#pubmedURLfulfill").val();
        if (pubmed.length > 0) {
            window.open(pubmed, '_blank');
        }
        return false;
    });

    $("#pubmedURLrpt").click(function () {
        var pubmed = $("#pubmedURLrpt").val();
        if (pubmed.length > 0) {
            window.open(pubmed, '_blank');
        }
        return false;
    });
}

//20200210
function openFullText() {
    $("#btndownloadFT").click(function () {
        var FTUrl = $("#FulltextURL").val();
        if (FTUrl.length > 0 && !FTUrl.endsWith('.pdf')) {
            window.open(FTUrl, '_blank');
        }
        else if (FTUrl.length > 0 && FTUrl.endsWith('.pdf')) {
            //$.ajax({
            //    url: FTUrl,
            //    cache: false,
            //    type: 'POST',
            //    xhrFields: {
            //        responseType: 'blob'
            //    },
            //    success: function (blob) {
            //        console.log(blob.size);
            //        var link = document.createElement('a');
            //        link.href = window.URL.createObjectURL(blob);
            //        link.download = $("#pmid").val()+ ".pdf";
            //        link.click();
            //    }
            //});
            var filename = $("#pmid").val() + ".pdf";
            //download_file(FTUrl, filename);

            //   download_pdf(filename, FTUrl);
            downloadfiles(filename, FTUrl);
        }
        return false;
    });
}

/* Helper function */
function download_file(fileURL, fileName) {
    // for non-IE
    if (!window.ActiveXObject) {
        var save = document.createElement('a');
        save.href = fileURL;
        save.target = '_blank';
        var filename = fileURL.substring(fileURL.lastIndexOf('/') + 1);
        save.download = fileName || filename;
        if (navigator.userAgent.toLowerCase().match(/(ipad|iphone|safari)/) && navigator.userAgent.search("Chrome") < 0) {
            document.location = save.href;
            // window event not working here
        } else {
            var evt = new MouseEvent('click', {
                'view': window,
                'bubbles': true,
                'cancelable': false
            });
            save.dispatchEvent(evt);
            (window.URL || window.webkitURL).revokeObjectURL(save.href);
        }
    }

    // for IE < 11
    else if (!!window.ActiveXObject && document.execCommand) {
        var _window = window.open(fileURL, '_blank');
        _window.document.close();
        _window.document.execCommand('SaveAs', true, fileName || fileURL)
        _window.close();
    }
}

function download_pdf(file, text) {

    //creating an invisible element 
    var element = document.createElement('a');
    element.setAttribute('href', 'data:text/plain;charset=utf-8, '
        + encodeURIComponent(text));
    element.setAttribute('download', file);

    //the above code is equivalent to 
    // <a href="path of file" download="file name"> 

    document.body.appendChild(element);

    //onClick property 
    element.click();

    document.body.removeChild(element);
}

function downloadfiles(filename, FTUrl) {
    $.ajax({
        url: FTUrl,
        success: function (data) {
            var blob = new Blob([data]);
            var link = document.createElement('a');
            link.href = window.URL.createObjectURL(blob);
            link.download = FTUrl;
            link.click();
        }
    });
}

function newdownload() {
    $('#btndownloadFT').on('click', function () {
        $.ajax({
            url: $("#FulltextURL").val(),
            method: 'GET',
            xhrFields: {
                responseType: 'blob'
            },
            success: function (data) {
                var a = document.createElement('a');
                var url = window.URL.createObjectURL(data);
                a.href = url;
                a.download = 'myfile.pdf';
                document.body.append(a);
                a.click();
                a.remove();
                window.URL.revokeObjectURL(url);
            }
        });
    });
}

function openEHostUrl() {
    $("#EhostURL").click(function () {
        var pubmed = $("#EhostURL").val();
        if (pubmed.length > 0) {
            window.open(pubmed, '_blank');
        }
        return false;
    }); 

    $("#EhostURLfulfill").click(function () {
        var pubmed = $("#EhostURLfulfill").val();
        if (pubmed.length > 0) {
            window.open(pubmed, '_blank');
        }
        return false;
    });

    $("#EhostURLrpt").click(function () {
        var pubmed = $("#EhostURLrpt").val();
        if (pubmed.length > 0) {
            window.open(pubmed, '_blank');
        }
        return false;
    }); 

}

function openFreeFTUrl() {
    $("#FreeFTURL").click(function () {
        var FreeFTURL = $("#FreeFTURL").val();
        if (FreeFTURL.length > 0) {
            window.open(FreeFTURL, '_blank');
        }
        return false;
    });

    $("#FreeFTURLfill").click(function () {
        var FreeFTURLfill = $("#FreeFTURLfill").val();
        if (FreeFTURLfill.length > 0) {
            window.open(FreeFTURLfill, '_blank');
        }
        return false;
    });

    $("#FreeFTURLrpt").click(function () {
        var FreeFTURLrpt = $("#FreeFTURLrpt").val();
        if (FreeFTURLrpt.length > 0) {
            window.open(FreeFTURLrpt, '_blank');
        }
        return false;
    });

}

var table; //in use
function displayTable(results) {
    //alert('displayTable');
    table=  $('#requestDataTable').DataTable({
        destroy: true,
        data: results,
       // scrollY: "200px",
        paging: false,
        searching: false,
        "ordering": false,
        "info": false,
        fixedColumns: true,
        "columns": [
            {
                "sTitle": "PMID", "data": "PMID",
                render: function (data, type, full, meta) {
                    return '<a style="color: blue;">' + data + '</a>';
                },
            },
            //{ "sTitle": "Title", "data": "Title"},"width": "200","word-wrap":"break-word" },
            { "sTitle": "Title", "data": "Title"},
            //{
            //    "sTitle": "Title", "data": "Title",
            //    render: function (data, type, full, meta) {
            //        return '<div class="text-wrap width-400px" style="height:20px">' + data + ' </div>';
            //      // return '<div class="text-wrap" style="height:25px;">' + data + ' </div>';
            //       // return '<td class="text-wrap width-400px" stylestatusfulfilled == "Fulfilled"="height:25px;">' + data + ' </td>';
            //    },
            //},
            { "sTitle": "Priority", "data": "Priority" },
            { "sTitle": "Requested By", "data": "RequestedBy" },
            { "sTitle": "Request Date", "data": "RequestedOn" },
            { "sTitle": "Status", "data": "Status" },
            // {
            //    "sTitle": "Download", "data": null,
            //     "defaultContent": '<td style="width:25px;text-align:center;"><a><span style="color:blue;" class="fa fa-cloud-download" ></span></a></td>'
                
            //},
            {
                "sTitle": "Actions", "data": null,
                "className": "center",
                "defaultContent": '<a class="editor_edit"><span class="fa fa-edit" style="color: blue;" title="Edit"></span> </a> | <a class="editor_download"><span class="fa fa-download" style="color: blue;" title="Download"></span></a>| <a class="editor_remove" style="color: red;">Cancel</a>',
                "render": function (data) {
                    if (data["Status"] === "Fulfilled") {
                        if (data["FTRetrievedFrom"] == "Free Downloads" || data["FTRetrievedFrom"] == "PDF Viewer" || data["FTRetrievedFrom"] == "PubMed") {
                            //return '<a class="editor_edit"><span class="fa fa-edit" style="color: blue;" title="Edit"></span> </a> | <a class="editor_download"><label class="fa fa-download" style="color: blue;" title="Download"></label></a>  <label style="color: green;font-weight: bold;" title="Freely available">Free</label>'
                            if (data["EhostFTLink"] != '' || data["PubMedFTURL"] != '' || data["FulltextURL"] != '') {
                                return '<a class="editor_edit"><span class="fa fa-edit" style="color: blue;" title="Edit"></span> </a> | <a class="editor_download"><span class="fa fa-download" style="color: blue;" title="Download"></span></a> | <a class="free_link"><span class="fa fa-external-link-square" style="color: green;" title="Click here to go to free Full Text link"></span></a>'
                            }
                            else {
                                return '<a class="editor_edit"><span class="fa fa-edit" style="color: blue;" title="Edit"></span> </a> | <a class="editor_download"><span class="fa fa-download" style="color: blue;" title="Download"></span></a>'
                            }
                        }
                        else {
                            return '<a class="editor_edit"><span class="fa fa-edit" style="color: blue;" title="Edit"></span> </a> | <a class="editor_download"><span class="fa fa-download" style="color: blue;" title="Download"></span></a>'
                        }
                    }
                    else if (data["Status"] === "Unavailable" || data["Status"] === "Cancelled Request"){

                        return '<a class="editor_edit"><span class="fa fa-edit" style="color: blue;" title="Edit"></span> </a>'
                    }
                    else {
                        if (data["FTRetrievedFrom"] == "Free Downloads" || data["FTRetrievedFrom"] == "PDF Viewer" || data["FTRetrievedFrom"] == "PubMed") {
                           // return '<a class="editor_edit"><label class="fa fa-edit" style="color: blue;" title="Edit"></label> </a>  | <a class="editor_remove"><label class="fa fa-times-circle" style="color: red;" title="Cancel request"></label></a>  <label style="color: green;font-weight: bold;" title="Freely available">Free</label>'
                            if (data["EhostFTLink"] != '' || data["PubMedFTURL"] != '' || data["FulltextURL"] != '') {
                                return '<a class="editor_edit"><span class="fa fa-edit" style="color: blue;" title="Edit"></span> </a>  | <a class="editor_remove"><span class="fa fa-times-circle" style="color: red;" title="Cancel request"></span></a> | <a class="free_link"><span class="fa fa-external-link-square" style="color: green;" title="Click here to go to free Full Text link"></span></a> '
                            }
                            else {
                                return '<a class="editor_edit"><span class="fa fa-edit" style="color: blue;" title="Edit"></span> </a>  | <a class="editor_remove"><span class="fa fa-times-circle" style="color: red;" title="Cancel request"></span></a>'
                            }
                        }
                        else {
                            return '<a class="editor_edit"><span class="fa fa-edit" style="color: blue;" title="Edit"></span> </a>  | <a class="editor_remove"><span class="fa fa-times-circle" style="color: red;" title="Cancel request"></span></a>'
                        }
                    }
                },
                
                //"defaultContent": '<a class="editor_edit" style="color: blue;">Edit</a> | <a class="editor_remove" style="color: red;">Delete</a> | <a class="editor_download" style="color: red;">download</a>',
             },
            //{
            //    "sTitle": "Delete", "data": null,
            //    "defaultContent": '<a class="editor_remove">Delete</a>'
            //},
            { "sTitle": "Record ID", "data": "RequestID", "targets":6, "visible": false},
            //{ "sTitle": "ReviewedBy", "data": "ReviewedBy" }
            { "sTitle": "FulltextURL", "data": "FulltextURL", "targets": 7, "visible": false },
            { "sTitle": "isReopened", "data": "isReopened", "targets": 8, "visible": false },
            { "sTitle": "EhostFTLink", "data": "EhostFTLink", "targets": 9, "visible": false },
            { "sTitle": "PubMedFTURL", "data": "PubMedFTURL", "targets": 10, "visible": false },
        ],
        "rowCallback": function (row, data, index) {
            $(row).find('td:eq(0)').css('color', 'blue');
            if (data["isReopened"] == true && data["Status"] === "In Progress") {
                $(row).css("background-color", "darkseagreen");
                $(row).addClass("warning");
            }

        }
            
    });
    $('a.editor_edit').on('click', function (e) {
        
       // var value = $(this).closest('tr').find('td:eq(7)').html();
        var pmidvalue = $(this).closest('tr').find('td:eq(0)').html();
        var tr = $(this).closest("tr"); //20200211 Anil Added
        var idx = tr.index();

        var isExpanded = $('#heading-example1').attr("aria-expanded");
        if (isExpanded == 'false') {
            $('#heading-example1').click();
        }

        $('#statusheading').html('Request Details');
        
        value = $("#requestDataTable").dataTable().fnGetData(idx).RequestID;

        var reopened = $("#requestDataTable").dataTable().fnGetData(idx).isReopened; //20200320

        $('#hdnreqid').val(value);
        $('#hdnpmid').val(pmidvalue);
        if (pageName == "FullTextRequest") {
            //GetRequestDetails(value); //20200226
            GetRequestDetails_Edit(value);
            $('#errorMessage').html('');
            $('#hdnreqid').val(value);
            $('#hdnpmid').val(pmidvalue);
            //var statusfulfilled = $(this).closest('tr').find('td:eq(4)').html();
            var statusfulfilled = $("#requestDataTable").dataTable().fnGetData(idx).Status;
            
            $('#collapseOne').removeClass('collapse show');
            $('#collapseOne').removeClass('show collapse');
            $('#collapseOne').removeClass('collapse');
            if (statusfulfilled == '') {
                $('#collapseOne').addClass('collapse');
            }
            else {
                $('#collapseOne').addClass('collapse show');
            }

            //20200210 
            if (statusfulfilled == "Fulfilled") {
                $("#btndownloadFT").show();
                $("#btndownloadFT").attr("disabled", false);
                $("#divfulfillerData").show();
                
            }
            else {
                $("#btndownloadFT").attr("disabled", true);
                $("#divfulfillerData").hide();

            }

            $("#btnReopenRequest").hide();

            //20200319
            if (statusfulfilled == "Fulfilled" || statusfulfilled == "Unavailable" || statusfulfilled == "Cancelled Request") {
                $("#btnReopenRequest").show();
                $("#btnReopenRequest").css({ marginLeft: '20%' });//works
                $("#btnAdd").css({ marginLeft: '1%' });
            }
            else {
               // $("#btnReopenRequest").css({ marginLeft: '20%' });//works
                $("#btnAdd").css({ marginLeft: '20%' });
            }

            $('#divRequestInfo').show();

          //  checkDatachanged();
            var $selectedRow = $(this).parent("td").parent("tr");
            $selectedRow.addClass("highlight").siblings().removeClass("highlight");
            $selectedRow.addClass("highlight");

            $("#searchcard").animate({ scrollTop: 750 }, "slow");
            
        } 
            //else if (pageName == "FullTextFullFiller") {
           
        //    GetFulfillDetails(value);
        //    $('#hdnreqid').val(value);
        //    $('#hdnpmid').val(pmidvalue);
        //    $("#myModal").modal();
        //}

     
       // $("#search").animate({ scrollTop: 700 }, "slow");
        //$('html, body').animate({
        //    scrollTop: $("#search").offset().top
        //}, 1000);

        //$("#searchcard").animate({ scrollTop: $("#divRequestInfo").offset().top-100 }, "slow");

        //$(this).addClass("highlight").siblings().removeClass("highlight");
        //$(this).addClass("highlight");
    });
    $('a.editor_remove').on('click', function (e) {
        //var value = $(this).closest('tr').find('td:eq(2)').html();
        var pmidvalue = $(this).closest('tr').find('td:eq(0)').html();
        var tr = $(this).closest("tr"); //20200211 Anil Added
        var idx = tr.index();

        var value = $("#requestDataTable").dataTable().fnGetData(idx).RequestID;
        var requestedby = '';
        requestedby = $(this).closest('tr').find('td:eq(3)').html();
        $('#hdnreqid').val(value);
        if (requestedby=='' || requestedby != sessionusername) {
            alert('You do not have permission to cancel this record!');
        } else {
            if (confirm('Are you sure want to cancel request?')) {
                DeleteRequest(value);
            }
        }
    });

    $('#requestDataTable tr td:nth-child(1)').on('click', function (e) {
        var pmidvaluestr = $(this).closest('tr').find('td:eq(0)').html();
        var pmidvalue = pmidvaluestr.replace('<a style="color: blue;">', '');
        pmidvalue = pmidvalue.replace('</a>', '');
        if (pmidvalue.length > 0) {
            //var PubmedUrl = "https://www.ncbi.nlm.nih.gov/pubmed/?term=" + pmidvalue.trim(); 
            //20200319 commented above linek and Added link for New PubMed Site
            var PubmedUrl = "https://pubmed.ncbi.nlm.nih.gov/" + pmidvalue.trim() + "/?from_single_result=" + + pmidvalue.trim();
            var Fturl = PubmedUrl;
            if (Fturl.length > 0) {
                window.open(Fturl, '_blank');
            }
        }
        return false; 
        //Commented Below Code on 20200219
        //var tr = $(this).closest("tr"); //20200211 Anil Added
        //var idx = tr.index();
      
        //value = $("#requestDataTable").dataTable().fnGetData(idx).RequestID;

        //$('#hdnreqid').val(value);
        //$('#hdnpmid').val(pmidvalue);
        //if (pageName == "FullTextRequest") {
        //    GetRequestDetails(value);

        //    $('#hdnreqid').val(value);
        //    $('#hdnpmid').val(pmidvalue);
        //    var statusfulfilled = $(this).closest('tr').find('td:eq(4)').html();
        //    $('#collapseOne').removeClass('collapse show');
        //    $('#collapseOne').removeClass('show collapse');
        //    $('#collapseOne').removeClass('collapse');
        //    if (statusfulfilled == '') {
        //        $('#collapseOne').addClass('collapse');
        //    }
        //    else {
        //        $('#collapseOne').addClass('collapse show');
        //    }

        //    //20200210 
        //    if (statusfulfilled == "Fulfilled") {
        //        $("#btndownloadFT").show();
        //        $("#btndownloadFT").attr("disabled", false);
        //    }
        //    else {
        //        $("#btndownloadFT").attr("disabled", true);

        //    }
        //    $('#divRequestInfo').show();
        //}
        
        //var $selectedRow = $(this).parent("td").parent("tr");
        //$selectedRow.addClass("highlight").siblings().removeClass("highlight");
        //$selectedRow.addClass("highlight");
        //$("#searchcard").animate({ scrollTop: 500 }, "slow");
       
    });

    $('a.editor_download').on('click', function (e) {
        var pmid = $(this).closest('tr').find('td:eq(0)').html();
        //  var reqid = $(this).closest('tr').find('td:eq(7)').html();
        //var ftfile = $(this).closest('tr').find('td:eq(8)').html();
        var tr = $(this).closest("tr");
        var idx = tr.index();

        var   reqid = $("#requestDataTable").dataTable().fnGetData(idx).RequestID;
        var  ftfile = $("#requestDataTable").dataTable().fnGetData(idx).FulltextURL;

        GetPMIDFilesTable('Fulltext', pmid, reqid, ftfile)
    });

    //20200415 Anil for Free Articles
    $('a.free_link').on('click', function (e) {
        var pmid = $(this).closest('tr').find('td:eq(0)').html();
        //  var reqid = $(this).closest('tr').find('td:eq(7)').html();
        //var ftfile = $(this).closest('tr').find('td:eq(8)').html();
        var tr = $(this).closest("tr");
        var idx = tr.index();

        var reqid = $("#requestDataTable").dataTable().fnGetData(idx).RequestID;
        var ftfile = $("#requestDataTable").dataTable().fnGetData(idx).FulltextURL;
        var EhostFTLink = $("#requestDataTable").dataTable().fnGetData(idx).EhostFTLink;
        var PubMedFTURL = $("#requestDataTable").dataTable().fnGetData(idx).PubMedFTURL;

        var freetextUrl = '';

        if (EhostFTLink != '') {
            freetextUrl = EhostFTLink;
        }
        else if (PubMedFTURL != '') {
            freetextUrl = PubMedFTURL;
        }
        else if (ftfile != '') {
            freetextUrl = ftfile;
        }

        if (freetextUrl.length > 0) {
            window.open(freetextUrl, '_blank');
        }
        
    });

}

//20200325 //in use
function GetRequestDetails(reqId) {

    if (reqId == '') {
        alert('Request ID must not be empty. Please select the record');
        return false;
    }

    $.ajax({
        type: "GET",
        url: "FullPageRequestService.asmx/GetRequestFullDetails",
        dataType: "json",
        data: {
            requestId: reqId,
            requestFrom: "FullTextRequest"
        },
        async: true,
        success: function (data) {

            $(data).each(function (index, req) {
                Clear();
                $('#btnAdd').html('Save Changes');
                $('#hdnreqid').val(req.RequestID);
                $('#hdnpmid').val(req.PMID);
                $('#pmid').val(req.PMID);
                $('#title').val(req.Title);
                $('#hdntitle').val(req.Title);
                $('#journaltitle').val(req.JournalTitle);
                $('#Citation').val(req.Citation);
                //20191219 Anil
                $('#pubmedURL').val(req.PubMedFTURL);
                $('#EhostURL').val(req.EhostFTLink);

                //Setting Hidden fields Data //20200226
                $('#hdnpriorityReq').val(req.Priority);
                $('#hdncostcenterReq').val(req.CostCenter);
                $('#hdnjtitleReq').val(req.JournalTitle);
                $('#hdnANtitleReq').val(req.Title);
                $('#hdncitationReq').val(req.Citation);
                $('#hdninstructionsReq').val(req.Instructions);
                //Till here

                if (req.PubMedFTURL == '') {
                    $("#divpubmedurl").css("display", "none");
                }
                else {
                    $("#divpubmedurl").css("display", "block");
                }

                if (req.EhostFTLink == '') {
                    $("#divehosturl").css("display", "none");
                }
                else {
                    $("#divehosturl").css("display", "block");
                }

                //20200428
                if (req.FulltextURL != '' && req.FTRetrievedFrom =='Free Downloads') {
                    
                    $("#divfreeFTUrl").css("display", "block");
                }
                else {
                    $("#divfreeFTUrl").css("display", "none");
                }

                $('#FreeFTURL').val(req.FulltextURL);


                $('#Instructions').val(req.Instructions);
                $("#Priority option").each(function () {
                    if ($(this).text() == req.Priority) {
                        $(this).prop('selected', true);
                    }
                });
                $('#divNESID').show();
                $('#divRequestedBy').show();
                $('#NESID').html(req.NESID);
                $('#RequestedBy').html(req.RequestedBy);
                $('#divRequestedOn').show();
                $('#RequestedOn').html(req.RequestedOn);

                $("#Status option").each(function () {
                    if ($(this).text() == req.Status) {
                        $(this).prop('selected', true);
                    }

                });


                if (req.CostCenter=='' && costcentersession != '') {
                    req.CostCenter = costcentersession;
                }


                $("#CostCenter option").each(function () {
                    if ($(this).text() == req.CostCenter) {
                        $(this).prop('selected', true);
                    }

                });

                $("#FTRetrievedFrom option").each(function () {
                    if ($(this).text() == req.FTRetrievedFrom) {
                        $(this).prop('selected', true);
                    }
                });

                $('#FulltextURL').val(req.FulltextURL);
                $('#Notes').val(req.Notes);
                $('#FulltextFile').val(req.FulltextFile);
                $('#SupplementMaterial').val(req.SupplementMaterial);
                $("input[name='optradio']").each(function () {
                    if ($(this).parent('label').text().trim() == req.PurchaseorSubscriptionType) {
                        $(this).prop('checked', true);
                    }
                });
                $('#Cost').val(req.Cost);
                $('#AutoRenewalURL').val(req.AutoRenewalURL);
                $("input[name='autourl']")[0].checked = req.AutoRenewal;
              
                changeftreviewed();

                if (req.AutoRenewalURL == '') {
                    $("#divSubscription").css("display", "none");
                }
                else {
                    $("#divSubscription").css("display", "block");
                }

                $('#hdnsavebtn').attr("disabled", false);
                //$('#btnAdd').attr("disabled", false); // For Hidden fields
                $('#btnAdd').attr("disabled", true);
                //$('#btnAdd').removeClass("btn btn-secondary").addClass("btn btn-success");
                $('#btnAdd').removeClass("btn btn-success").addClass("btn btn-secondary");

              
                $("#btnReopenRequest").hide();

                if (req.RequestedBy != sessionusername) {
                    //$('#btnAdd').hide();
                    $('#btnAdd').removeClass("btn btn-success").addClass("btn btn-secondary");
                    $('#btnAdd').attr("disabled", true);
                    $('#hdnsavebtn').attr("disabled", true);
                    // $('#btnClear').hide();
                    $("#btnReopenRequest").hide();
                }

                if (req.RequestedBy == sessionusername) {
                    if (req.IsRequested == "True") {
                        //$('#btnSubmit').hide();

                    }
                    else {
                        $('#errorMessage').html('Cancelled request');
                    }
                }

                if (req.Status == "Fulfilled" || req.Status == "Unavailable" || req.Status == "Cancelled Request") { //20200325
                    $("#btnReopenRequest").show();
                    $("#btnReopenRequest").css({ marginLeft: '20%' });//works
                    $("#btnAdd").css({ marginLeft: '1%' });
                }
                else {
                    $("#btnReopenRequest").hide();
                    $("#btnAdd").css({ marginLeft: '20%' });
                }

             
                $('#lblFTfilenames').html(req.FTFileNames);
                $('#lblpurchasefilenames').html(req.PurchaseFileNames);


                //20200206
                if (req.Status == "Fulfilled") {

                    //20200210 Anil
                    $('#btndownloadFT').show();
                    $("#btndownloadFT").attr("disabled", false);
                    
                    //$("#btnAdd").attr("disabled", true);
                    $("#divfulfillerData").show();

                    $('#btndownloadFT').removeClass("btn btn-secondary").addClass("btn btn-success");

                     $('#errorMessage').show();
                     $('#errorMessage').html('Existing request available');
                   //  $('#collapse-example').collapse('hide');

                }
                else {

                    if (req.Status == "Unavailable") //20200225
                    {
                        $('#errorMessage').html('Full text is unavailable for this PMID');
                        $('#errorMessage').show();
                     //   $('#collapse-example').collapse('hide');
                    }
                    else if (req.Status == "Cancelled Request") {
                        $('#errorMessage').html('Cancelled Request');
                        $('#errorMessage').show();
                    }
                    else {

                        $('#errorMessage').show();
                        $('#errorMessage').html('Existing request in progress');
                       // $('#collapse-example').collapse('hide');
                    }

                    //$('#btndownloadFT').hide();
                    $('#btndownloadFT').removeClass("btn btn-success").addClass("btn btn-secondary");
                    $("#btndownloadFT").attr("disabled", true);
                    $('#btndownloadreceipt').removeClass("btn btn-success").addClass("btn btn-secondary");
                    $("#btndownloadreceipt").attr("disabled", true);

                    //$("#btnAdd").attr("disabled", false);
                    $("#divfulfillerData").hide();
                }

                //20200320
                if (req.isReopened == true && req.Status == "In Progress") {
                    $('#pmid').css({ backgroundColor: 'darkseagreen' });//works
                }
                else {
                    $('#pmid').css({ backgroundColor: '' });//works
                }

            });

        },
        complete: function () {

        },
        error: function (err) {
            console.log(err);
        }
    });
}

function GetRequestDetails_Edit(reqId) {

    if (reqId == '') {
        alert('Request ID must not be empty. Please select the record');
        return false;
    }

    $.ajax({
        type: "GET",
        url: "FullPageRequestService.asmx/GetRequestFullDetails",
        dataType: "json",
        data: {
            requestId: reqId,
            requestFrom: "FullTextRequest"
        },
        async: true,
        success: function (data) {

            $(data).each(function (index, req) {
                Clear();
                $('#btnAdd').html('Save Changes');
                $('#hdnreqid').val(req.RequestID);
                $('#hdnpmid').val(req.PMID);
                $('#pmid').val(req.PMID);
                $('#title').val(req.Title);
                $('#hdntitle').val(req.Title);
                $('#journaltitle').val(req.JournalTitle);
                $('#Citation').val(req.Citation);
                //20191219 Anil
                $('#pubmedURL').val(req.PubMedFTURL);
                $('#EhostURL').val(req.EhostFTLink);

                //Setting Hidden fields Data //20200226
                $('#hdnpriorityReq').val(req.Priority);
                $('#hdncostcenterReq').val(req.CostCenter);
                $('#hdnjtitleReq').val(req.JournalTitle);
                $('#hdnANtitleReq').val(req.Title);
                $('#hdncitationReq').val(req.Citation);
                $('#hdninstructionsReq').val(req.Instructions);
                //Till here

                if (req.PubMedFTURL == '') {
                    $("#divpubmedurl").css("display", "none");
                }
                else {
                    $("#divpubmedurl").css("display", "block");
                }

                if (req.EhostFTLink == '') {
                    $("#divehosturl").css("display", "none");
                }
                else {
                    $("#divehosturl").css("display", "block");
                }

                //20200428
                if (req.FulltextURL != '' && req.FTRetrievedFrom == 'Free Downloads') {

                    $("#divfreeFTUrl").css("display", "block");
                }
                else {
                    $("#divfreeFTUrl").css("display", "none");
                }

                $('#FreeFTURL').val(req.FulltextURL);

                $('#Instructions').val(req.Instructions);
                $("#Priority option").each(function () {
                    if ($(this).text() == req.Priority) {
                        $(this).prop('selected', true);
                    }
                });
                $('#divNESID').show();
                $('#divRequestedBy').show();
                $('#NESID').html(req.NESID);
                $('#RequestedBy').html(req.RequestedBy);
                $('#divRequestedOn').show();
                $('#RequestedOn').html(req.RequestedOn);

                $("#Status option").each(function () {
                    if ($(this).text() == req.Status) {
                        $(this).prop('selected', true);
                    }

                });

                if (req.CostCenter == '' && costcentersession != '') {
                    req.CostCenter = costcentersession;
                }

                $("#CostCenter option").each(function () {
                    if ($(this).text() == req.CostCenter) {
                        $(this).prop('selected', true);
                    }

                });

                $("#FTRetrievedFrom option").each(function () {
                    if ($(this).text() == req.FTRetrievedFrom) {
                        $(this).prop('selected', true);
                    }
                });
                $('#FulltextURL').val(req.FulltextURL);
                $('#Notes').val(req.Notes);
                $('#FulltextFile').val(req.FulltextFile);
                $('#SupplementMaterial').val(req.SupplementMaterial);
                $("input[name='optradio']").each(function () {
                    if ($(this).parent('label').text().trim() == req.PurchaseorSubscriptionType) {
                        $(this).prop('checked', true);
                    }
                });
                $('#Cost').val(req.Cost);
                $('#AutoRenewalURL').val(req.AutoRenewalURL);
                $("input[name='autourl']")[0].checked = req.AutoRenewal;

                changeftreviewed();

                if (req.AutoRenewalURL == '') {
                    $("#divSubscription").css("display", "none");
                }
                else {
                    $("#divSubscription").css("display", "block");
                }

                $('#hdnsavebtn').attr("disabled", false);
                //$('#btnAdd').attr("disabled", false); // For Hidden fields
                $('#btnAdd').attr("disabled", true);
                
                $('#btnAdd').removeClass("btn btn-secondary").addClass("btn btn-success");
                $('#btnAdd').removeClass("btn btn-success").addClass("btn btn-secondary");

                if (req.RequestedBy != sessionusername) {
                    //$('#btnAdd').hide();
                    $('#btnAdd').removeClass("btn btn-success").addClass("btn btn-secondary");
                    $('#btnAdd').attr("disabled", true);
                    $('#hdnsavebtn').attr("disabled", true);
                    // $('#btnClear').hide();
                }

                $('#lblFTfilenames').html(req.FTFileNames);
                $('#lblpurchasefilenames').html(req.PurchaseFileNames);

                //20200206
                if (req.Status == "Fulfilled") {

                    //20200210 Anil
                    $('#btndownloadFT').show();
                    $("#btndownloadFT").attr("disabled", false);
                    //$("#btnAdd").attr("disabled", true);
                    $("#divfulfillerData").show();

                    $('#btndownloadFT').removeClass("btn btn-secondary").addClass("btn btn-success");

                    //$('#errorMessage').show();
                    //$('#errorMessage').html('Existing request available');
                    //  $('#collapse-example').collapse('hide');

                }
                else {

                    //if (req.Status == "Unavailable") //20200225
                    //{
                    //    $('#errorMessage').html('Full text is unavailable for this PMID');
                    //    $('#errorMessage').show();
                    //    //   $('#collapse-example').collapse('hide');
                    //}
                    //else {

                    //    $('#errorMessage').show();
                    //    $('#errorMessage').html('Existing request in progress');
                    //}
                    //$('#btndownloadFT').hide();
                    $('#btndownloadFT').removeClass("btn btn-success").addClass("btn btn-secondary");
                    $("#btndownloadFT").attr("disabled", true);
                    $('#btndownloadreceipt').removeClass("btn btn-success").addClass("btn btn-secondary");
                    $("#btndownloadreceipt").attr("disabled", true);

                    //$("#btnAdd").attr("disabled", false);
                    $("#divfulfillerData").hide();
                    $('#errorMessage').hide();
                }

                //20200320
                if (req.isReopened == true && req.Status == "In Progress") {
                    $('#pmid').css({ backgroundColor: 'darkseagreen' });//works
                }
                else {
                    $('#pmid').css({ backgroundColor: '' });//works
                }

            });

        },
        complete: function () {

        },
        error: function (err) {
            console.log(err);
        }
    });
}

function GetFulfillDetails(reqId) {


    if (reqId == '') {
        alert('Request ID must not be empty. Please select the record');
        return false;
    }

    $.ajax({
        type: "GET",
        url: "FullPageRequestService.asmx/GetRequestFullDetails",
        dataType: "json",
        data: {
            requestId: reqId,
            requestFrom: "FullTextFullFiller"
        },
        async: true,
        success: function (data) {

            $(data).each(function (index, req) {
                Clear();
                $('#btnSubmit').html('Submit');
                $('#hdnreqid').val(req.RequestID);
                $('#pmidfulfiller1').val(req.PMID);
                $('#titlefulfill').val(req.Title);
                $('#journaltitlefulfill').val(req.JournalTitle);
                $('#Citationfulfill').val(req.Citation);
                $('#Instructionsfulfill').val(req.Instructions);
             
                $('#pubmedURLfulfill').val(req.PubMedFTURL);
                $('#EhostURLfulfill').val(req.EhostFTLink);

                if (req.PubMedFTURL == '') {
                    $('#divpubmedFulfill').hide();
                }
                else {
                    $('#divpubmedFulfill').show();
                }

                if (req.EhostFTLink == '') {
                    $('#divehostFulfill').hide();
                }
                else {
                    $('#divehostFulfill').show();
                }

                //20200428
                if (req.FulltextURL != '' && req.FTRetrievedFrom == 'Free Downloads') {

                    $("#divfreeFTUrlfill").css("display", "block");
                }
                else {
                    $("#divfreeFTUrlfill").css("display", "none");
                }

                $('#FreeFTURLfill').val(req.FulltextURL);


                $("#Priorityfulfill option").each(function () {
                    if ($(this).text() == req.Priority) {
                        $(this).prop('selected', true);
                    }
                });
                $("#Statusfulfill option").each(function () {
                    if ($(this).text() == req.Status) {
                        $(this).prop('selected', true);
                    }
                });

                $("#CostCenterfulfill option").each(function () {
                    if ($(this).text() == req.CostCenter) {
                        $(this).prop('selected', true);
                    }
                });

                $("#FTRetrievedFromfulfill option").each(function () {
                    if ($(this).text() == req.FTRetrievedFrom) {
                        $(this).prop('selected', true);
                    }
                });
                $('#NESIDfulfiller').val(req.NESID);
                $('#RequestedByfulfill').val(req.RequestedBy);
                $('#RequestedOnfulfill').val(req.RequestedOn);
                $('#FulltextURLfulfill').val(req.FulltextURL);
                $('#Notesfulfill').val(req.Notes);
                $('#FulltextFilefulfill').val(req.FulltextFile);
                $('#SupplementMaterialfulfill').val(req.SupplementMaterial);

                $("input[name='optradiofulfill']").each(function () {
                    if ($(this).parent('label').text().trim() == req.PurchaseorSubscriptionType) {
                        $(this).prop('checked', true);
                    }
                });

                $('#Costfulfill').val(req.Cost);
                $('#AutoRenewalURLfulfill').val(req.AutoRenewalURL);

                $("input[name='AutoRenewalfulfill']")[0].checked = req.AutoRenewal;

                if (req.IsReviewed == "True") {
                    $('#btnSubmit').html('Save Changes');
                }
                $('#lblFTfilenames').html(req.FTFileNames);
                $('#lblpurchasefilenames').html(req.PurchaseFileNames);
                //changeftreviewed();   
                changeftreviewedfulfill();
                $('#btnSubmit').hide();
                $('#btnClear').hide();
                if (req.ReviewedBy == '' || req.ReviewedBy == sessionusername) {
                    $('#btnSubmit').show();
                  //  $('#btnClear').show();
                }

                //20200320
                if (req.isReopened == true && req.Status == "In Progress") {
                    $('#pmidfulfiller1').css({ backgroundColor: 'darkseagreen' });//works
                }
                else {
                    $('#pmidfulfiller1').css({ backgroundColor: '' });//works
                }

            });

        },
        error: function (err) {
            console.log(err);
        }
    });
}


function GetReportDetails(reqId) {


    if (reqId == '') {
        alert('Request ID must not be empty. Please select the record');
        return false;
    }

    $.ajax({
        type: "GET",
        url: "FullPageRequestService.asmx/GetRequestFullDetails",
        dataType: "json",
        data: {
            requestId: reqId,
            requestFrom: "Report"
        },
        async: true,
        success: function (data) {

            $(data).each(function (index, req) {
                ClearRpt();
                $('#hdnreqidrpt').val(req.RequestID);
                $('#pmidrpt').val(req.PMID);
                $('#titlerpt').val(req.Title);
                $('#journaltitlerpt').val(req.JournalTitle);
                $('#Citationrpt').val(req.Citation);
                //20191219 Anil
                $('#pubmedURLrpt').val(req.PubMedFTURL);
                $('#EhostURLrpt').val(req.EhostFTLink);
            
                $('#lblFTfilenamesrpt').html(req.FTFileNames);
                $('#lblpurchasefilenamesrpt').html(req.PurchaseFileNames);

                if (req.FTFileNames == '') { //20200318
                    //btnFTDownloadrpt
                    //"btn-primary pull-left fa fa-cloud-download"
                    //   $('#btndownloadFT').removeClass("btn btn-success").addClass("btn btn-secondary");
                    $("#btnFTDownloadrpt").attr("disabled", true);
                }
                else {
                    $("#btnFTDownloadrpt").attr("disabled", false);
                }
                if (req.PurchaseFileNames == '') { //20200318
                    $("#btnreceiptDownloadrpt").attr("disabled", true);
                }
                else {
                    $("#btnreceiptDownloadrpt").attr("disabled", false);
                }


                if (req.PubMedFTURL == '') {

                    $('#divpubmedrpt').hide();
                }
                else {
                    $('#divpubmedrpt').show();
                }

                if (req.EhostFTLink == '') {

                    $('#divehostrpt').hide();
                }
                else {
                    $('#divehostrpt').show();
                }

                //20200428
                if (req.FulltextURL != '' && req.FTRetrievedFrom == 'Free Downloads') {

                    $("#divfreeFTUrlrpt").css("display", "block");
                }
                else {
                    $("#divfreeFTUrlrpt").css("display", "none");
                }

                $('#FreeFTURLrpt').val(req.FulltextURL);

                $('#Instructionsrpt').val(req.Instructions);

                $("#Priorityrpt option").each(function () {
                    if ($(this).text() == req.Priority) {
                        $(this).prop('selected', true);
                    }
                });

                $("#Statusrpt option").each(function () {
                    if ($(this).text() == req.Status) {
                        $(this).prop('selected', true);
                    }
                });

                $("#CostCenterrpt option").each(function () {
                    if ($(this).text() == req.CostCenter) {
                        $(this).prop('selected', true);
                    }
                });


                $("#FTRetrievedFromrpt option").each(function () {
                    if ($(this).text() == req.FTRetrievedFrom) {
                        $(this).prop('selected', true);
                    }
                });

                $('#NESIDrpt').val(req.NESID);
                $('#RequestedByrpt').val(req.RequestedBy);
                $('#RequestedOnrpt').val(req.RequestedOn);
                $('#FulltextURLrpt').val(req.FulltextURL);
                $('#Notesrpt').val(req.Notes);
                $('#FulltextFilerpt').val(req.FulltextFile);
                $('#SupplementMaterialrpt').val(req.SupplementMaterial);


                $("input[name='optradiorpt']").each(function () {
                    if ($(this).parent('label').text().trim() == req.PurchaseorSubscriptionType) {
                        $(this).prop('checked', true);
                    }
                });
                $('#Costrpt').val(req.Cost);

                $('#AutoRenewalURLrpt').val(req.AutoRenewalURL);

                $("input[name='AutoURLrpt']")[0].checked = req.AutoRenewal;

                //20200505
                if (req.FulltextURL != '' && req.FTRetrievedFrom == 'Subscription/Purchased') {

                    $("#divPurchaserpt").css("display", "block");
                }
                else {
                    $("#divPurchaserpt").css("display", "none");
                }


                if (req.AutoRenewalURL !='') {
                    
                    $("#divSubscriptionrpt").css("display", "block");
                }
                else {
                    $("#divSubscriptionrpt").css("display", "none");
                }


                if (req.IsReviewed == "True") {
                    $('#btnSubmit').hide();
                }
                // changeftreviewed();
            });

        },
        error: function (err) {
            console.log(err);
        }
    });
}

function displayTableReport_old(results) {

    table = $('#requestDataTablerpt').DataTable({
        data: results,
        destroy: true,
        scrollY: "500px",
       "scrollCollapse": true,
        "scrollX": true,
        //searching: false,
        //paging: false,
        //"ordering": false,
        //"info": false,
        //"processing": true,
       
        "columns": [
            { "data": "RequestID" },
            { "data": "NESID" },
            { "data": "PMID" },
            { "data": "Title" },
            { "data": "JournalTitle" },
            { "data": "Citation" },
            { "data": "Instructions" },
            { "data": "Priority" },
            { "data": "Status" },
            { "data": "FTRetrievedFrom" },
            { "data": "EhostFTLink" },
            { "data": "PubMedFTURL" },
            { "data": "FulltextURL" },
            { "data": "FulltextFile" },
            { "data": "SupplementMaterial" },
            { "data": "Notes" },
            { "data": "RequestedOn" },
            { "data": "RequestedBy" },
            { "data": "ReviewedOn" },
            { "data": "ReviewedBy" }
        ],
        dom: 'Bfrtip',
        buttons: [
            { extend: 'csv', className: 'copyButton' },
            { extend: 'excelHtml5', className: 'buttons-excel buttons-html5' }
            //'csv','excelHtml5',
        ],
    });


    $('#requestDataTablerpt tbody').on('click', 'tr', function () {
        $(this).addClass("highlight").siblings().removeClass("highlight");
        $(this).addClass("highlight");
        var value = $(this).find('td:eq(0)').html();
        $('#hdnreqidrpt').val(value);
        //GetFulfillDetails(value);
        GetReportDetails(value); //ToDO:
        $("#myModal").modal();
    });
}

function BindData(data) {
    var requestTable = $('#requestDataTable tbody');
    alert(requestTable);
    requestTable.empty();
    var cnt = 0;
    $(data).each(function (index, req) {
        cnt = cnt + 1;
        
        requestTable.append('<tr><td><a><span style="color:#0080A0;" class="fa fa-edit" ></span></a></td>' +
            '<td style="display:none">' + req.RequestID + '</td> <td>' + req.PMID + '</td> <td>'
            + req.Title + '</td><td>' + req.Priority + '</td>' +
            '<td>' + req.RequestedBy + '</td>' +
            '<td>' + req.Status + '</td>' +
            '<td>' + req.ReviewedBy + '</td></tr> ');

    });
    $('#totalrecords').html('Total records:' + cnt);
    //$('#requestDataTable tr td:nth-child(1) a').click(function () {
    //    alert('hi');
    //    var value = $(this).closest('tr').find('td:eq(2)').html();
    //    $('#hdnreqid').val(value);
    //    GetFulfillDetails(value);
    //    var $selectedRow = $(this).parent("td").parent("tr");
    //    $selectedRow.addClass("highlight").siblings().removeClass("highlight");
    //    $selectedRow.addClass("highlight");
    //    $("#myModal").modal();


      
    //});
}

function BindRequestData(data) {
  //  alert('ak');
    displayTable(data);
    return;
    var requestTable = $('#requestDataTable tbody');
    requestTable.empty();
    var cnt = 0;
    if (data == '') {
        requestTable.append('<tr><td colspan="6">No Records</td></tr>');
    }
    else {
        $(data).each(function (index, req) {
            cnt = cnt + 1;
           // var RequestStatus = '';

            //if (req.IsRequested == "True") {
              //  RequestStatus = 'Requested';
           // }
           // else if (req.IsRequested == "False") {
               // RequestStatus = 'Not Requested';
           // }
            var Status = req.Status;
            var columnhtml = '<td><a><span style="color:red;cursor:hand;" class="fa fa-remove"></span></a></td>';
            if (Status == 'Fulfilled' || Status == 'In Progress')
                columnhtml = '<td><a style="display:none;cursor:hand;"><span style="color:red;" class="fa fa-remove"></span></a></td>';

            var requestedby = req.RequestedBy;
            var edithtml = '<td><a><span style="color:#0080A0;cursor:hand;" class="fa fa-edit" ></span></a></td>';
            if (requestedby != sessionusername) {
                // edithtml = '<td style="width:25px;"><a style="display:none;"><span style="color:#0080A0;" class="fa fa-edit" ></span></a></td>';
                columnhtml = '<td><a style="display:none;"><span style="color:red;" class="fa fa-remove"></span></a></td>';
            }

            requestTable.append('<tr>' + edithtml +
                columnhtml +
                '<td style="display:none">' + req.RequestID + '</td> <td>' + req.PMID + '</td> <td>'
                + req.Title + '</td><td>' + req.Priority + '</td>' +
                '<td>' + req.RequestedBy + '</td>' +
                '<td >' + req.Status + '</td>' +
                '<td >' + req.ReviewedBy + '</td></tr> ');

        });
        $('#totalrecords').html('Total records:' + cnt);
        $('#requestDataTable tr td:nth-child(1) a').click(function () {
            var value = $(this).closest('tr').find('td:eq(2)').html();
            GetRequestDetails(value);
            $('#hdnreqid').val(value);
            var pmidvalue = $(this).closest('tr').find('td:eq(3)').html();
            $('#hdnpmid').val(pmidvalue);
            //alert(pmidvalue);
            var statusfulfilled = $(this).closest('tr').find('td:eq(6)').html();
            $('#collapseOne').removeClass('collapse show');
            $('#collapseOne').removeClass('show collapse');
            $('#collapseOne').removeClass('collapse');
            if (statusfulfilled == '') {
                $('#collapseOne').addClass('collapse');
            }
            else {
                $('#collapseOne').addClass('collapse show');
            }
            var $selectedRow = $(this).parent("td").parent("tr");
            $selectedRow.addClass("highlight").siblings().removeClass("highlight");
            $selectedRow.addClass("highlight");
        });
        $('#requestDataTable tr td:nth-child(2) a').click(function () {
            var value = $(this).closest('tr').find('td:eq(2)').html();
            $('#hdnreqid').val(value);
            if (confirm('Are you sure want to cancel request?')) {
                DeleteRequest(value);
            }
        });
    }
}

function BindDownloadData(data, type) {
    //var requestTable = $('#downloadDataTable tbody');
    //requestTable.empty();

    var requestTable = $('#downloadDataTable').DataTable({
        destroy: true,
        data: data,
        // scrollY: "200px",
        paging: false,
        searching: false,
        "ordering": false,
        "info": false,
        fixedColumns: true,
        "columns": [
            {
                "sTitle": "Actions", "data": "",
                "className": "center",
                "text-align": "center",
                "defaultContent": '<a><span style="color:blue;" class="fa fa-cloud-download" title="Click here to download file"></span></a>',
            },
            { "sTitle": "File ID", "data": "FileID" },
            { "sTitle": "File Name", "data": "FileName" },
            { "sTitle": "FileType", "data": "ContentType" },
        ],
        "rowCallback": function (row, data, index) {
            // if (data["isReopened"] == true && data["Status"] === "In Progress") {
            // $(row).css("background-color", "darkseagreen");
            // $(row).addClass("warning");
            // }

        }

    });
    //alert(JSON.stringify(data.length));
    if (data.length > 0) {

        $('#downloadDataTable tr td:nth-child(1) a').click(function () {
            var fileid = $(this).closest('tr').find('td:eq(1)').html();
            //alert(fileid);
            downloadFile('fulltext', fileid);
            //downloadFileTable('fulltext', fileid, pmid, hdnreqid);
            var $selectedRow = $(this).parent("td").parent("tr");
            $selectedRow.addClass("highlight").siblings().removeClass("highlight");
            $selectedRow.addClass("highlight");
        });

        $("#downloadModal").modal();


    }
    else if (data.length == 0 && type == "fulltext") {
        var Fturl = $("#FulltextURL").val();
        if (Fturl.length > 0) {
            window.open(Fturl, '_blank');
        }
        return false;
    }
}

function GetRequest() {

    $.ajax({
        type: "GET",
        url: "FullPageRequestService.asmx/GetRequestFullDetails",
        dataType: "json",
        data: {
            requestId: "",
            requestFrom: pageName
        },
        async: true,
        success: function (data) {
            if (pageName == "FullTextFullFiller") {
               // BindData(data);
               //alert('hi1');
                displayTable(data);
            }
            else {
                //BindRequestData(data);
                displayTable(data);
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function GetSearchRequest_New() {
    var username = sessionusername;
    //  $('#search').show();
    $('#divRequestInfo').hide();
    $('#Fulfill').hide();
    $('#Report').hide();
    if (pageName == "FullTextRequest") {
        modestatus = 1;// $('#RequestStatus option:selected').val();
        var usertext = $('#Username option:selected').text();
    }
    //if (pageName == "FullTextFullFiller") {
    //    fromdate = $('#From').val();
    //    todate = $('#To').val();
    //    var usertext = $('#Username option:selected').text();
    //    if (usertext == 'AllUsers')
    //        username = '';
    //}
    $.ajax({
        type: "GET",
        //url: "FullPageRequestService.asmx/GetRequestFullDetailsForReport_New",
        url: "FullPageRequestService.asmx/GetRequestFullDetailsForReport_New",
        dataType: "json",
        async: true,
        data: {
            PMID: $('#pmid1').val(),
            FromPage: pageName,
            Username: username
        },
        success: function (data) {
            displayTable(data);
            $('#divRequestInfo').hide(); //Ak
        },
        error: function (err) {
            console.log(err);
        }
    });
}
function GetSearchFulfiller() {
    //  $('#search').hide();
    $('#Fulfill').show();
    $('#Report').hide();
    $('#btnsearchfulfiller').focus();
    var statustext = $('#Statusfulfiller option:selected').text();
    if (statustext == '--select--')
        statustext = '';
    var Prioritytext = $('#Priorityfulfiller option:selected').text();
    if (Prioritytext == '--select--')
        Prioritytext = '';
    var modestatus = 1;
    var fromdate = '';
    var todate = '';
    var ftretrievedfrom = '';
    if ($('#FTRetrievedFromfulfiller').length > 0)
        ftretrievedfrom = $('#FTRetrievedFromfulfiller option:selected').text();
    if (ftretrievedfrom == '--select--')
        ftretrievedfrom = '';
    var username = sessionusername;
    if (pageName == "FullTextRequest") {
        modestatus = 1;// $('#RequestStatus option:selected').val();
        var usertext = $('#Username option:selected').text();
        if (usertext == 'AllUsers')
            username = '';
        fromdate = $('#From').val();
        todate = $('#To').val();
    }
    if (pageName == "FullTextFullFiller") {
        fromdate = $('#Fromfulfiller').val();
        todate = $('#Tofulfiller').val();
        var usertext = $('#Usernamefulfiller option:selected').text();
        if (usertext == 'AllUsers')
            username = '';
    }
    $.ajax({
        type: "GET",
        url: "FullPageRequestService.asmx/GetRequestFullFillerDetailsForReport",
        dataType: "json",
        async: true,
        data: {
            Status: statustext,
            Priority: Prioritytext,
            PMID: $('#pmidfulfiller').val(),
            FromPage: "FullTextFullFiller",
            Username: username,
            From: fromdate,
            To: todate,
            Modestatus: modestatus,
            FTRetrievedFrom: ftretrievedfrom
        },
        success: function (data) {
            //if (pageName == "FullTextFullFiller") {
            //BindData(data);
            displayFulfillTable(data);
            //}
            //else {
            //    //BindRequestData(data);
            // //   displayFulfillTable(data);
            //}
        },
        error: function (err) {
            console.log(err);
        }
    });
}
function GetReportDetailsNew() {
    $('#Report').show();
    var statustext = $('#Statusfrpt option:selected').text();
    if (statustext == '--select--')
        statustext = '';
    var Prioritytext = $('#Priorityfrpt option:selected').text();
    if (Prioritytext == '--select--')
        Prioritytext = '';
    var FromPage = $('#FromPage option:selected').text();
    if (FromPage == '--select--')
        FromPage = '';
    var Isslam = 0;
    //if ($('#chkslam').checked == true) {
    //    Isslam = 1;
    //}

    if ($('#chkslam').prop('checked') == true) {
        Isslam = 1;
    }

    var CostCenter = $('#CostCenterfrpt option:selected').text();
    if (CostCenter == '--select--')
        CostCenter = '';

    $.ajax({
        type: "GET",
        url: "FullPageRequestService.asmx/GetRequestFullDetailsForReport",
        dataType: "json",
        data: {
            Status: statustext,
            Priority: Prioritytext,
            PMID: $('#pmidfrpt').val(),
            //FromPage: FromPage,
            FromPage: "Report",
            Username: $('#Usernamefrpt').val(),
            From: $('#From').val(),
            To: $('#To').val(),
            Modestatus: 1,//$('#Modestatus option:selected').val()
            FTRetrievedFrom: '',
            Isslam: Isslam,
            CostCenter: CostCenter
        },
        error: function (x, y) {
            debugger;
            console.log(x);
        },
        success: function (results, args) {
            displayTableReport(results);
            // now();
        }
    });
}
function GetSearchRequestSave() {
    var username = sessionusername;
    if (pageName == "FullTextRequest") {
        modestatus = 1;// $('#RequestStatus option:selected').val();
        var usertext = $('#Username option:selected').text();
    }
    //if (pageName == "FullTextFullFiller") {
    //    fromdate = $('#From').val();
    //    todate = $('#To').val();
    //    var usertext = $('#Username option:selected').text();
    //    if (usertext == 'AllUsers')
    //        username = '';
    //}
    $.ajax({
        type: "GET",
        //url: "FullPageRequestService.asmx/GetRequestFullDetailsForReport_New",
        url: "FullPageRequestService.asmx/GetRequestFullDetailsForReport_New",
        dataType: "json",
        async: true,
        data: {
            PMID: $('#pmid1').val(),
            FromPage: pageName,
            Username: username
        },
        success: function (data) {
            displayTable(data);
          //  $('#divRequestInfo').hide(); //Ak
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function bs_input_file() {
    $(".input-file").before(
        function () {
            if (!$(this).prev().hasClass('input-ghost')) {
                var element = $("<input type='file' class='input-ghost' style='visibility:hidden; height:0'>");
                element.attr("name", $(this).attr("name"));
                element.change(function () {
                    element.next(element).find('input').val((element.val()).split('\\').pop());
                });
                $(this).find("button.btn-choose").click(function () {
                    element.click();
                });
                $(this).find("button.btn-reset").click(function () {
                    element.val(null);
                    $(this).parents(".input-file").find('input').val('');
                });
                $(this).find('input').css("cursor", "pointer");
                $(this).find('input').mousedown(function () {
                    $(this).parents('.input-file').prev().click();
                    return false;
                });
                return element;
            }
        }
    );
}
//$(function () {
//    bs_input_file();
//});


function deleteFile(type, fileid) {

    var pmid = $('#pmid').val();
    if (pmid == '') {
        alert('PMID must not be empty. Please select the record');
        return false;
    }
    var hdnreqid = $('#hdnreqid').val();
    if (hdnreqid == '') {
        alert('Request ID must not be empty. Please select the record');
        return false;
    }
    var request = new XMLHttpRequest();
    var params = "pmid=" + pmid + "&requestId=" + hdnreqid + "&type=" + type + "&filetype=delete&fileid=" + fileid + "";
    request.responseType = 'text';
    request.open("GET", "FileUploader.ashx" + "?" + params, true);
    request.onload = function () {
        if (request.readyState === request.DONE) {
            if (request.status === 200) {
                console.log(request.response);
                //alert("File deleted successfully");
                alert(request.response);
                $("#downloadModal").modal('toggle');
                GetPMIDFiles('');
                GetPMIDFiles(type);
            }
        }
    };
    request.send(null);


}

function deleteFileFulfill(type, fileid, pmid, reqid) {

    //var pmid = $('#pmid').val();
    if (pmid == '') {
        alert('PMID must not be empty. Please select the record');
        return false;
    }
    var hdnreqid = reqid; // $('#hdnreqid').val();
    if (hdnreqid == '') {
        alert('Request ID must not be empty. Please select the record');
        return false;
    }
    var request = new XMLHttpRequest();
    var params = "pmid=" + pmid + "&requestId=" + hdnreqid + "&type=" + type + "&filetype=delete&fileid=" + fileid + "";
    request.responseType = 'text';
    request.open("GET", "FileUploader.ashx" + "?" + params, true);
    request.onload = function () {
        if (request.readyState === request.DONE) {
            if (request.status === 200) {
                console.log(request.response);
                //alert("File deleted successfully");
                alert(request.response);
                $("#downloadModalfulfill").modal('toggle');
                //GetPMIDFiles('');
                //GetPMIDFiles(type);

                var pmidd = $('#pmidfulfiller1').val();
                var hdnreqidd = $('#hdnreqid').val();
                //GetPMIDFilesTable('fulltext', pmidd, hdnreqidd, ''); //20200220
                GetPMIDFilesFulfill('');
            }
        }
    };
    request.send(null);


}

function deleteAllFiles() {

    var pmid = $('#pmidfulfiller1').val();
    if (pmid == '') {
        alert('PMID must not be empty. Please select the record');
        return false;
    }
    var hdnreqid = $('#hdnreqid').val();
    if (hdnreqid == '') {
        alert('Request ID must not be empty. Please select the record');
        return false;
    }
    var request = new XMLHttpRequest();
    var params = "pmid=" + pmid + "&requestId=" + hdnreqid + "&filetype=deleteall";
    request.responseType = 'text';
    request.open("GET", "FileUploader.ashx" + "?" + params, true);
    request.onload = function () {
        if (request.readyState === request.DONE) {
            if (request.status === 200) {
                console.log(request.response);
               // alert(request.response);
                //alert("Files are deleted successfully");
            }
        }
    };
    request.send(null);

}


function downloadFile(type, fileid) {

    var pmid = $('#pmid').val();
    var hdnreqid = $('#hdnreqid').val();
    if (pmid == '') {
       alert('PMID must not be empty. Please select the record');
        return false;
    }
    if (hdnreqid == '') {
       alert('Request ID must not be empty. Please select the record');
        return false;
    }

    var progressBar;

    var perecent;
    if (type == 'fulltext') {

        progressBar = document.getElementById("progress");
        perecent = document.getElementById("perecent");
    }


    else if (type == 'supplement') {

        progressBar = document.getElementById("progress1");
        perecent = document.getElementById("perecent1");
    }

    else {
        return;
    }


    var request = new XMLHttpRequest();

    var params = "pmid=" + pmid + "&requestId=" + hdnreqid + "&type=" + type + "&filetype=download&fileid=" + fileid + "";

    request.open("GET", "FileUploader.ashx" + "?" + params, true);

    // request.open("POST", "FileUploader.ashx");
    request.responseType = 'arraybuffer';
    request.upload.onprogress = function (e) {
        if (e.lengthComputable) {
            progressBar.max = e.total;
            progressBar.value = e.loaded;
            var ratio = Math.floor((e.loaded / e.total) * 100) + '%';
            perecent.innerHTML = ratio;
        }
    }
    request.upload.onloadstart = function (e) {
        progressBar.value = 0;
    }
    request.upload.onloadend = function (e) {
        progressBar.value = e.loaded;
    }


    request.onload = function () {
        if (this.status === 200) {
            var filename = "";
            var disposition = request.getResponseHeader('Content-Disposition');
            if (disposition && disposition.indexOf('attachment') !== -1) {
                var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
                var matches = filenameRegex.exec(disposition);
                if (matches != null && matches[1]) filename = matches[1].replace(/['"]/g, '');
            }
            var type = request.getResponseHeader('Content-Type');

            var blob = new Blob([this.response], { type: type });
            if (typeof window.navigator.msSaveBlob !== 'undefined') {
                // IE workaround for "HTML7007: One or more blob URLs were revoked by closing the blob for which they were created. These URLs will no longer resolve as the data backing the URL has been freed."
                window.navigator.msSaveBlob(blob, filename);
            } else {
                var URL = window.URL || window.webkitURL;
                var downloadUrl = URL.createObjectURL(blob);

                if (filename) {
                    // use HTML5 a[download] attribute to specify filename
                    var a = document.createElement("a");
                    // safari doesn't support this yet
                    if (typeof a.download === 'undefined') {
                        window.location = downloadUrl;
                    } else {
                        a.href = downloadUrl;
                        a.download = filename;
                        document.body.appendChild(a);
                        a.click();
                    }
                } else {
                    window.location = downloadUrl;
                }

                setTimeout(function () { URL.revokeObjectURL(downloadUrl); }, 100); // cleanup
            }
        }
    };

    request.send(null);


    var file1 = $("#divPurchaseFile").find('input');
    if (file1)
        $("#divPurchaseFile").find('input').val('');
    var file2 = $("#divFullTextFile").find('input');
    if (file2)
        $("#divFullTextFile").find('input').val('');

    $('#perecent').html('');
    $('#progress').val('0');
}


function sendFile(type) {

    var pmid = $('#pmidfulfiller1').val();
    var hdnreqid = $('#hdnreqid').val();
    if (pmid == '') {
        alert('PMID must not be empty. Please select the record');
        return false;
    }
    if (hdnreqid == '') {
        alert('Request ID must not be empty. Please select the record');
        return false;
    }

    var progressBar;
    var fileUpload;
    var perecent;
    if (type == 'fulltext') {
        fileUpload = $(".input-ghost")[0];
        progressBar = document.getElementById("progress");
        perecent = document.getElementById("perecent");
    }


    else if (type == 'supplement') {
        fileUpload = $(".input-ghost")[1];
        progressBar = document.getElementById("progress1");
        perecent = document.getElementById("perecent1");
    }

    else {
        return;
    }

    var files = fileUpload.files;

    var data = new FormData();
    for (var i = 0; i < files.length; i++) {
        data.append(files[i].name, files[i]);
        if (type == 'fulltext') {
            var lblFTfilenames = $('#lblFTfilenames').html();
            if (lblFTfilenames.indexOf(pmid + '-' + files[i].name + ',') >= 0) {
                alert('File already exist!');
                return;
            }
        }
        else if (type == 'supplement') {
            var lblpurchasefilenames = $('#lblpurchasefilenames').html();
            if (lblpurchasefilenames.indexOf(pmid + '-' + files[i].name + ',') >= 0) {
                alert('File already exist!');
                return;
            }
        }

    }
    data.append("pmid", pmid);
    data.append("type", type);
    data.append("requestId", hdnreqid);
    if (files.length <= 0) {
        alert('Files are not available. Please browse file');
        return;
    }

    var formData = data;
    var request = new XMLHttpRequest();
    request.open("POST", "FileUploader.ashx", true);

    request.upload.onprogress = function (e) {
        if (e.lengthComputable) {
            progressBar.max = e.total;
            progressBar.value = e.loaded;
            var ratio = Math.floor((e.loaded / e.total) * 100) + '%';
            perecent.innerHTML = ratio;
        }
    }
    request.upload.onloadstart = function (e) {
        progressBar.value = 0;
    }
    request.upload.onloadend = function (e) {
        progressBar.value = e.loaded;
    }

    request.onload = function () {
        if (request.readyState === request.DONE) {
            if (request.status === 200) {
                alert(request.response);
                formData = null;
                fileUpload = null;
                var file1 = $("#divPurchaseFile").find('input');
                //if (file1) {
                //    $("#divPurchaseFile").find('input').val('');
                //}
                var file2 = $("#divFullTextFile").find('input');
                //if (file2) {
                //    $("#divFullTextFile").find('input').val('');
                //}

                $('#perecent').html('');
                $('#progress').val('0');
                $('#perecent1').html('');
                $('#progress1').val('0');
                //if (type == 'fulltext') {
                //    $(".input-ghost")[0].value = '';
                //}
                //else if (type == 'supplement') {
                //    $(".input-ghost")[1].value = '';
                //}
               // GetPMIDFiles(''); //20200212
                var pmidd = $('#pmidfulfiller1').val();
                var hdnreqidd = $('#hdnreqid').val();
                GetPMIDFilesFulfill('');
                if (type == 'fulltext') {
                    //GetPMIDFiles('fulltext');//20200212
                    //GetPMIDFilesTable('fulltext', pmidd, hdnreqidd, '');
                    GetPMIDFilesFulfill('fulltext');
                  //  BindDownloadfulfillData('fulltext',pmidd,) 
                }
                else if (type == 'supplement') {
                    //GetPMIDFiles('supplement');//20200212
                    //GetPMIDFilesTable('supplement', pmidd, hdnreqidd, '');
                    GetPMIDFilesFulfill('supplement');
                }

                

            }
        }
    };

    request.send(formData);

}

function UploadFileDirect(type) {

    var pmid = $('#pmidfulfiller1').val();
    var hdnreqid = $('#hdnreqid').val();
    if (pmid == '') {
        alert('PMID must not be empty. Please select the record');
        return false;
    }
    if (hdnreqid == '') {
        alert('Request ID must not be empty. Please select the record');
        return false;
    }

    var progressBar;
    var fileUpload;
    var perecent;
    //TODO:20200220
    if (type == 'fulltext') {
        //$('#progress').show();
        $("#progress").css("display", "block");
        fileUpload = $("#ftfile");
        progressBar = document.getElementById("progress");
        perecent = document.getElementById("perecent");
    }


    else if (type == 'supplement') {
        $("#progress1").css("display", "block");
        
        fileUpload = $("#supfile"); // $(".input-ghost")[1];
        progressBar = document.getElementById("progress1");
        perecent = document.getElementById("perecent1");
    }

    else {
        return;
    }

   
    var files = fileUpload[0].files; // .files;

    var data = new FormData();
    for (var i = 0; i < files.length; i++) {
        data.append(files[i].name, files[i]);
        if (type == 'fulltext') {
            var lblFTfilenames = $('#lblFTfilenames').html();
            if (lblFTfilenames.indexOf(pmid + '-' + files[i].name + ',') >= 0) {
                alert('File already exist!');
                $("#progress").css("display", "none");
                return;
            }
        }
        else if (type == 'supplement') {
            var lblpurchasefilenames = $('#lblpurchasefilenames').html();
            if (lblpurchasefilenames.indexOf(pmid + '-' + files[i].name + ',') >= 0) {
                alert('File already exist!');
                $("#progress1").css("display", "none");
                return;
            }
        }

    }
    data.append("pmid", pmid);
    data.append("type", type);
    data.append("requestId", hdnreqid);
    if (files.length <= 0) {
        alert('Files are not available. Please browse file');
        $("#progress").css("display", "none");
        $("#progress1").css("display", "none");
        return;
    }

    var formData = data;
    var request = new XMLHttpRequest();
    request.open("POST", "FileUploader.ashx", true);
    //20200227
    request.upload.onprogress = function (e) {
        if (e.lengthComputable) {
            progressBar.max = e.total;
            progressBar.value = e.loaded;
            var ratio = Math.floor((e.loaded / e.total) * 100) + '%';
            perecent.innerHTML = ratio;
        }
    }
    request.upload.onloadstart = function (e) {
        progressBar.value = 0;
    }
    request.upload.onloadend = function (e) {
        progressBar.value = e.loaded;
        $("#progress").css("display", "none");
        $("#progress1").css("display", "none");
    }

    request.onload = function () {
        if (request.readyState === request.DONE) {
            if (request.status === 200) {
                alert(request.response);
                formData = null;
                fileUpload = null;
                var file1 = $("#divPurchaseFile").find('input');
                //if (file1) {
                //    $("#divPurchaseFile").find('input').val('');
                //}
                var file2 = $("#divFullTextFile").find('input');
                //if (file2) {
                //    $("#divFullTextFile").find('input').val('');
                //}

                $('#perecent').html('');
                $('#progress').val('0');
                $('#perecent1').html('');
                $('#progress1').val('0');
                //if (type == 'fulltext') {
                //    $(".input-ghost")[0].value = '';
                //}
                //else if (type == 'supplement') {
                //    $(".input-ghost")[1].value = '';
                //}
                // GetPMIDFiles(''); //20200212
                var pmidd = $('#pmidfulfiller1').val();
                var hdnreqidd = $('#hdnreqid').val();
                GetPMIDFilesFulfill('');
            }
        }
    };

    //$('#progress').hide();
    //$('#progress1').hide();
    //$("#progress").css("display", "none");
    //$("#progress1").css("display", "none");
    request.send(formData);
  

}


$('.modal-child').on('show.bs.modal', function () {
    var modalParent = $(this).attr('data-modal-parent');
    $(modalParent).css('opacity', 0);
});

$('.modal-child').on('hidden.bs.modal', function () {
    var modalParent = $(this).attr('data-modal-parent');
    $(modalParent).css('opacity', 1);
});



function GetData() {
    $('#statusMessage').html('');
    $('#errorMessage').html('');
    //var pmid = $('#pmid').val();// 20200206
   // var pm = $this.val();
   
    var pmid = $('#pmid1').val();
    
    if (pmid.length>0) {
        $.ajax({
            type: "GET",
            url: "FullPageRequestService.asmx/Downloaddata",
            //data: {
            //    pubmedURL: "https://www.ncbi.nlm.nih.gov/pubmed/?term=" + pmid
            //}, //Anil Commented and Added Below code 20200118
            data: {
                pmid: pmid
            },
            //beforeSend: function () {
            //    // Show image container
            //    $("#loader").show();
            //},
            dataType: "json",
            async: true,
            error: function (xhr, ajaxOptions, thrownError) {
                //for debug
                //alert(xhr.status);
                //alert(xhr.responseText);
                //alert(thrownError);
                alert('PMID may not be available or invalid!');
                Clear();
            },
            success: function (data) {
                //alert(data);
                $(data).each(function (index, req) {

                    $('#pmid').val(pmid); //20200206 Anil
                    $('#Citation').val(req.Citation);
                    $('#title').val(req.Title);
                    $('#journaltitle').val(req.JournalTitle);
                    $('#pubmedURL').val(req.PubMedFTURL);
                    $('#EhostURL').val(req.EhostFTLink);
                    //20200206
                    if (req.status == "Fulfilled") {
                        $('#btndownloadFT').show();
                        $("#btndownloadFT").attr("disabled", false);

                        //$('#btndownloadreceipt').show();
                        //$("#btndownloadreceipt").attr("disabled", false);
                    }
                    else {
                        $('#btndownloadFT').hide();
                        $("#btndownloadFT").attr("disabled", true);

                        $('#btndownloadreceipt').hide();
                        $("#btndownloadreceipt").attr("disabled", true);

                    }
                    if (req.isExists == true) {
                        //$('#errorMessage').html(req.errorMessage);
                      
                        //$('#errorMessage').show();
                        //$('#btnAdd').html('Request Full Text');
                        ////$('#btnAdd').hide();
                        //$('#btnAdd').attr("disabled", true);
                    }
                    else {
                     //   $('#errorMessage').hide();
                        //$('#btnAdd').show();
                        $('#btnAdd').attr("disabled", false);
                    }

                    if ((req.PubMedFTURL != null && req.PubMedFTURL != '') || (req.EhostFTLink != null && req.EhostFTLink != '')) {
                        $('#btnAdd').html('Open Free Full Text');
                    }
                });
            },
            //complete: function (data) {
            //    // Hide image container
            //    $("#loader").hide();
            //}

        });
    }
}

// in use
function GetDatapmid() {
    $('#statusMessage').html('');
    $('#errorMessage').html('');
    //var pmid = $('#pmid').val();// 20200206
    // var pm = $this.val();
    var pmid = $('#pmid1').val();
    pmid = pmid.trim();
    if (pmid.length > 0) {
        $.ajax({
            type: "GET",
            //url: "FullPageRequestService.asmx/Downloaddata_New",
            url: "FullPageRequestService.asmx/SearchandDownloaddata",
            data: {
                pmid: pmid
            },
            dataType: "json",
            async: true,
            success: function (data) {
                //alert(data);
                $('#divRequestInfo').show();
              //  $("#searchcard").animate({ scrollTop: 200 }, "slow"); // UnComment if Close My recent Requests div
                $("#searchcard").animate({ scrollTop: 750 }, "slow");
                $(data).each(function (index, req) {
                    if (req.isExists == true) {
                        if (req.RequestID != '' && req.RequestID != null) {
                            GetRequestDetails(req.RequestID);
                            //$('#errorMessage').html('Existing request available !');
                            //$('#errorMessage').show();
                        }
                        //$('#errorMessage').show();
                        //$('#errorMessage').html('Existing request available');
                        //$('#collapse-example').collapse('hide');
                    }
                    else {


                        $('#pmid').val(pmid); //20200206 Anil
                        $('#Citation').val(req.Citation);
                        $('#title').val(req.Title);
                        $('#journaltitle').val(req.JournalTitle);
                        $('#pubmedURL').val(req.PubMedFTURL);
                        $('#EhostURL').val(req.EhostFTLink);
                        $('#FulltextURL').val(req.FulltextURL);
                        $('#Instructions').val(req.Instructions);
                        $('#hdnFTUrl').val(req.FulltextURL);
                        
                        $('#statusheading').html('Request Details');
                        //20200410
                        if (costcentersession != '') {
                            $('#CostCenter').val(costcentersession);
                        }
                        else {
                            $('#CostCenter').val('-1');
                        }


						//20200306
						if (req.PubMedFTURL == '') {
                            $("#divpubmedurl").css("display", "none");
                        }
                        else {
                            $("#divpubmedurl").css("display", "block");
                        }

                        if (req.EhostFTLink == '') {
                            $("#divehosturl").css("display", "none");
                        }
                        else {
                            $("#divehosturl").css("display", "block");
                        }

                        //20200428
                        if (req.FulltextURL != '' && req.FTRetrievedFrom == 'Free Downloads') {

                            $("#divfreeFTUrl").css("display", "block");
                        }
                        else {
                            $("#divfreeFTUrl").css("display", "none");
                        }

                        $('#FreeFTURL').val(req.FulltextURL);

                        $("#btnReopenRequest").hide();
                        //$("#btnReopenRequest").css({ marginLeft: '20%' });//works
                        $("#btnAdd").css({ marginLeft: '20%' });

                        //20200206
                        if (req.isExists == true) {

                            
                        }
                        else {
                            $('#statusheading').html('New Request Form');
                            //$('#errorMessage').hide();
                            $('#divfulfillerData').hide();
                            //$('#btnAdd').show();
                            $('#btnAdd').removeClass("btn btn-secondary").addClass("btn btn-success");
                            $('#btndownloadFT').removeClass("btn btn-success").addClass("btn btn-secondary");
                            $('#btndownloadreceipt').removeClass("btn btn-success").addClass("btn btn-secondary");

                            $('#btnAdd').attr("disabled", false);
                            $('#btndownloadFT').attr("disabled", true);
                            $('#btndownloadreceipt').attr("disabled", true);
                        }

                        $("#FTRetrievedFrom option").each(function () {
                            if ($(this).text() == req.FTRetrievedFrom) {
                                $(this).prop('selected', true);
                            }
                        });

                        if (pmid.includes(",")) {
                            $('#pmid').val('');
                        }

                        // 20200409 Commented by Anil as till then only PMC and Ehost Free Ft were Checked
                        //if ((req.PubMedFTURL != null && req.PubMedFTURL != '') || (req.EhostFTLink != null && req.EhostFTLink != '')) {
                        //    $('#btnAdd').html('Open Free Full Text');
                        //}

                        // 20200409 Added by Anil as till then only PMC and Ehost Free Ft were Checked instead check Notes
                        if (req.Instructions != null && req.Instructions == 'Free article, please download and attach PDF') {
                            $('#btnAdd').html('Open Free Full Text');
                        }

                    }

                });
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert('PMID may not be available or invalid!');
                Clear();
            },
        });
    }
}

function GetPMIDFiles(type) {
    var pmid = $('#pmid').val();
    if (pmid == '') {
        alert('PMID must not be empty');
        return false;
    }
    var reqid = $('#hdnreqid').val();
    if (reqid == '') {
        alert('Please select record');
        return false;
    }
    var requestTable = $('#downloadDataTable tbody');
    requestTable.empty();
    $.ajax({
        type: "GET",
        url: "FullPageRequestService.asmx/GetPMIDFiles",
        dataType: "json",
        data: {
            pmid: pmid,
            type: type,
            requestId: reqid,
        },
        async: true,
        success: function (data) {
            if (type == '') {
                var ftFilenames = '';
                var purchaseFileNames = '';
                $(data).each(function (index, req) {
                    if (req.Type == "fulltext")
                        ftFilenames += req.FileName + ',';
                    else if (req.Type == "supplement")
                        purchaseFileNames += req.FileName + ",";
                });
                $('#lblFTfilenames').html(ftFilenames);
                $('#lblpurchasefilenames').html(purchaseFileNames);
            }
            else {
                BindDownloadData(data, type);
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}


//20200211 Anil Added
function downloadfromgrid() {
    $('#requestDataTable tr td:nth-child(5) a').click(function () {
        var pmid = $(this).closest('tr').find('td:eq(0)').html();
        var reqid = $(this).closest('tr').find('td:eq(7)').html();
        GetPMIDFilesTable('fulltext', pmid, reqid)
    });
}

function GetPMIDFilesTable(type, pmid, reqid, ftfile) {
    //var pmid = $('#pmid').val();

    var pmidd = pmid; //JSON.stringify({ pmid: pmid });
    //JSON.stringify({ Username: sessionusername });
    var reqidd = reqid; // JSON.stringify({ reqid: reqid });
    
    if (pmidd == '') {
        return false;
    }
    if (reqidd == '') {
        return false;
    }
  //  GetPMIDFiles(type);

    pmidd = pmidd.replace('<a style="color: blue;">', '');
    pmidd = pmidd.replace('</a>', '');

    var requestTable = $('#downloadDataTable tbody');
    requestTable.empty();
    $.ajax({
        type: "GET",
        //contentType: "application/json; charset=utf-8",
        url: "FullPageRequestService.asmx/GetPMIDFiles",
        dataType: "json",
        data: {
            pmid: pmidd,
            type: type,
            requestId: reqidd,
        },
        async: true,
        success: function (data) {
            if (type == '') {
                var ftFilenames = '';
                var purchaseFileNames = '';
                $(data).each(function (index, req) {
                    if (req.Type == "fulltext")
                        ftFilenames += req.FileName + ',';
                    else if (req.Type == "supplement")
                        purchaseFileNames += req.FileName + ",";
                });
                $('#lblFTfilenames').html(ftFilenames);
                $('#lblpurchasefilenames').html(purchaseFileNames);
            }
            else {
                BindDownloadDataTable(data, type, pmidd, reqidd, ftfile);
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function BindDownloadDataTable_Old(data, type, pmid, hdnreqid, ftfile) {
    var requestTable = $('#downloadDataTable tbody');
    requestTable.empty();

    var deletehtml = '';
    if (pageName == "FullTextRequest") {
        deletehtml = '<td style="display:none;width:25px;"><a><span style="color:red;" class="fa fa-remove" ></span></a></td>';
    }
    else if (pageName == "FullTextFullFiller") {
        deletehtml = '<td style="width:25px;"><a><span style="color:red;" class="fa fa-remove" ></span></a></td>';
    }
    //alert(JSON.stringify(data.length));

    if (data.length > 0) {
        $(data).each(function (index, req) {
            requestTable.append('<tr>' +
                '<td style="width:25px;"><a><span style="color:blue;" class="fa fa-cloud-download" ></span></a></td>' +
                deletehtml +
                '<td style="display:none;">' + req.FileID + '</td>' +
                '<td style="width:20%;">' + req.FileName + '</td>' +
                '<td style = "width:30%;">' + req.UploadedDate + '</td> <td style="width:30%;">'
                + req.ContentType + '</td></tr > ');

        });

        $('#downloadDataTable tr td:nth-child(1) a').click(function () {
            var fileid = $(this).closest('tr').find('td:eq(2)').html();
            downloadFileTable('fulltext', fileid, pmid, hdnreqid);
            var $selectedRow = $(this).parent("td").parent("tr");
            $selectedRow.addClass("highlight").siblings().removeClass("highlight");
            $selectedRow.addClass("highlight");
        });
        $('#downloadDataTable tr td:nth-child(2) a').click(function () {
            var fileid = $(this).closest('tr').find('td:eq(2)').html();
            deleteFile(type, fileid);
            var $selectedRow = $(this).parent("td").parent("tr");
            $selectedRow.addClass("highlight").siblings().removeClass("highlight");
            $selectedRow.addClass("highlight");
           
        });

        $("#downloadModal").modal();
       

    }
    else if (data.length == 0 && type.toLowerCase() == "fulltext") {
        var Fturl = ftfile;
        if (Fturl.length > 0) {
            window.open(Fturl, '_blank');
        }
        return false;
    }

  
}

function downloadFileTable(type, fileid, pmid, hdnreqid) {
    if (pmid == '') {
        return false;
    }
    if (hdnreqid == '') {
        return false;
    }

    var progressBar;

    var perecent;
    if (type == 'fulltext') {

        progressBar = document.getElementById("progress");
        perecent = document.getElementById("perecent");
    }


    else if (type == 'supplement') {

        progressBar = document.getElementById("progress1");
        perecent = document.getElementById("perecent1");
    }

    else {
        return;
    }


    var request = new XMLHttpRequest();

    var params = "pmid=" + pmid + "&requestId=" + hdnreqid + "&type=" + type + "&filetype=download&fileid=" + fileid + "";

    request.open("GET", "FileUploader.ashx" + "?" + params, true);

    // request.open("POST", "FileUploader.ashx");
    request.responseType = 'arraybuffer';
    request.upload.onprogress = function (e) {
        if (e.lengthComputable) {
            progressBar.max = e.total;
            progressBar.value = e.loaded;
            var ratio = Math.floor((e.loaded / e.total) * 100) + '%';
            perecent.innerHTML = ratio;
        }
    }
    request.upload.onloadstart = function (e) {
        progressBar.value = 0;
    }
    request.upload.onloadend = function (e) {
        progressBar.value = e.loaded;
    }


    request.onload = function () {
        if (this.status === 200) {
            var filename = "";
            var disposition = request.getResponseHeader('Content-Disposition');
            if (disposition && disposition.indexOf('attachment') !== -1) {
                var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
                var matches = filenameRegex.exec(disposition);
                if (matches != null && matches[1]) filename = matches[1].replace(/['"]/g, '');
            }
            var type = request.getResponseHeader('Content-Type');

            var blob = new Blob([this.response], { type: type });
            if (typeof window.navigator.msSaveBlob !== 'undefined') {
                // IE workaround for "HTML7007: One or more blob URLs were revoked by closing the blob for which they were created. These URLs will no longer resolve as the data backing the URL has been freed."
                window.navigator.msSaveBlob(blob, filename);
            } else {
                var URL = window.URL || window.webkitURL;
                var downloadUrl = URL.createObjectURL(blob);

                if (filename) {
                    // use HTML5 a[download] attribute to specify filename
                    var a = document.createElement("a");
                    // safari doesn't support this yet
                    if (typeof a.download === 'undefined') {
                        window.location = downloadUrl;
                    } else {
                        a.href = downloadUrl;
                        a.download = filename;
                        document.body.appendChild(a);
                        a.click();
                    }
                } else {
                    window.location = downloadUrl;
                }

                setTimeout(function () { URL.revokeObjectURL(downloadUrl); }, 100); // cleanup
            }
        }
    };

    request.send(null);


    var file1 = $("#divPurchaseFile").find('input');
    if (file1)
        $("#divPurchaseFile").find('input').val('');
    var file2 = $("#divFullTextFile").find('input');
    if (file2)
        $("#divFullTextFile").find('input').val('');

    $('#perecent').html('');
    $('#progress').val('0');
}


function onlyNumberKey(evt) {

    // Only ASCII charactar in that range allowed comma and space
    var ASCIICode = (evt.which) ? evt.which : evt.keyCode
    if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57) && ASCIICode != 44 && ASCIICode != 32)
        return false;
    return true;
} 


function displayFulfillTable(results) {
   //alert('displayTable');
    var table= $('#fulfillDataTable').DataTable({
        destroy: true,
        data: results,
        //scrollY: "300px",
        paging: true,
        searching: false,
        "ordering": false,
        //"info": false,
        "scrollCollapse": true,
        "columns": [
            { "sTitle": "PMID", "data": "pmidfulfiller1" },
            { "sTitle": "Title", "data": "Titlefulfill" },
            { "sTitle": "Priority", "data": "Priorityfulfill" },
            { "sTitle": "RequestedBy", "data": "RequestedByfulfill" },
            { "sTitle": "Status", "data": "Statusfulfill" },
            {
                "sTitle": "Edit", "data": null,
                "defaultContent": '<a class="editor_editfulfill" id="editor_editfulfill" style="color: blue;"><span class="fa fa-edit" style="color: blue;" title="Edit"></span></a>',
            },
            {
                "sTitle": "Record ID", "data": "RequestIDfulfill", "targets": 6 },
            {
                "sTitle": "FulltextURL", "data": "FulltextURLfulfill", "targets": 7}
        ],
        "rowCallback": function (row, data, index) { //20200320
            if (data["Reopenedfulfiller"] == true && data["Statusfulfill"] === "In Progress") {
                $(row).css("background-color", "darkseagreen");
                $(row).addClass("warning");
            }

        }
    });

    table.column(6).visible(false);
    table.column(7).visible(false);

   // $('a.editor_editfulfill').on('click', function (e) { //20200318
   // $('#fulfillDataTable').on('click','tr td.editor_editfulfill', function (e) {
        $("#fulfillDataTable").on("click", ".editor_editfulfill", function (e) {
          e.preventDefault();

        // var value = $(this).closest('tr').find('td:eq(7)').html();
        var pmidvalue = $(this).closest('tr').find('td:eq(0)').html();
        var tr = $(this).closest("tr"); //20200211 Anil Added
        var idx = tr.index();
            var data = $('#fulfillDataTable').dataTable().fnGetData(tr);

        value = $("#fulfillDataTable").dataTable().fnGetData(idx).RequestIDfulfill;

        $('#hdnreqidfulfiller').val(value);
        $('#hdnpmidfulfiller').val(pmidvalue);
        $('#statusMessagefulfill').val('');
        $('#errorMessagefulfill').html('');
        $('#statusMessagefulfill').html('');
        if (pageName == "FullTextFullFiller") {

            //GetFulfillDetails(value);
            GetFulfillDetails(pmidvalue);
            $('#hdnreqidfulfiller').val(value);
            $('#hdnpmidfulfiller').val(pmidvalue);
            $("#myModalfulfill").modal();
        }

        var $selectedRow = $(this).parent("td").parent("tr");
        $selectedRow.addClass("highlight").siblings().removeClass("highlight");
        $selectedRow.addClass("highlight");

        //$(this).addClass("highlight").siblings().removeClass("highlight");
        //$(this).addClass("highlight");
    });
  
}

function GetPMIDFilesFulfill(type) {

    var pmidd = $('#pmidfulfiller1').val();
    var hdnreqidd = $('#hdnreqid').val();

    //var pmid = $('#pmid').val();
    var pmid = pmidd;
    if (pmid == '') {
        alert('PMID must not be empty');
        return false;
    }
    var reqid = $('#hdnreqid').val();
    if (reqid == '') {
        alert('Please select record');
        return false;
    }
    var requestTable = $('#downloadDataTableFulfill tbody');
    requestTable.empty();
    $.ajax({
        type: "GET",
        url: "FullPageRequestService.asmx/GetPMIDFiles",
        dataType: "json",
        data: {
            pmid: pmid,
            type: type,
            requestId: reqid,
        },
        async: true,
        success: function (data) {
            if (type == '') {
                var ftFilenames = '';
                var purchaseFileNames = '';
                $(data).each(function (index, req) {
                    if (req.Type == "fulltext")
                        ftFilenames += req.FileName + ',';
                    else if (req.Type == "supplement")
                        purchaseFileNames += req.FileName + ",";
                });
                $('#lblFTfilenames').html(ftFilenames);
                $('#lblpurchasefilenames').html(purchaseFileNames);
            }
            else {
                BindDownloadfulfillData(data, type, pmid, reqid);
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function ShowUploadedFiles(type) {

    var pmidd = $('#pmidfulfiller1').val();
    var hdnreqidd = $('#hdnreqid').val();
    
    //var pmid = $('#pmid').val();
    var pmid = pmidd;
    if (pmid == '') {
        alert('PMID must not be empty');
        return false;
    }
    var reqid = $('#hdnreqid').val();
    if (reqid == '') {
        alert('Please select record');
        return false;
    }
    var requestTable = $('#downloadDataTableFulfill tbody');
    requestTable.empty();
    $.ajax({
        type: "GET",
        url: "FullPageRequestService.asmx/GetPMIDFiles",
        dataType: "json",
        data: {
            pmid: pmid,
            type: type,
            requestId: reqid,
        },
        async: true,
        success: function (data) {
            if (type == '') {
                var ftFilenames = '';
                var purchaseFileNames = '';
                $(data).each(function (index, req) {
                    if (req.Type == "fulltext")
                        ftFilenames += req.FileName + ',';
                    else if (req.Type == "supplement")
                        purchaseFileNames += req.FileName + ",";
                });

                $('#lblFTfilenames').html(ftFilenames);
                $('#lblpurchasefilenames').html(purchaseFileNames);
            }
            else {
                //BindDownloadfulfillData(data, type, pmid, reqid);
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}

//20200212
function BindDownloadfulfillData_old(data, type, pmid, reqid) {
    var requestTable = $('#downloadDataTableFulfill tbody');
    requestTable.empty();

    var deletehtml = '';
    if (pageName == "FullTextRequest") {
        deletehtml = '<td style="display:none;width:25px;"><a><span style="color:red;" class="fa fa-remove" ></span></a></td>';
    }
    else if (pageName == "FullTextFullFiller") {
        deletehtml = '<td style="width:25px;"><a><span style="color:red;" class="fa fa-remove" ></span></a></td>';
    }
    //alert(JSON.stringify(data.length));
    if (data.length > 0) {
        $(data).each(function (index, req) {
            requestTable.append('<tr>' +
                '<td style="width:25px;"><a><span style="color:blue;" class="fa fa-cloud-download" ></span></a></td>' +
                deletehtml +
                '<td style="display:none;">' + req.FileID + '</td>' +
                '<td style="width:20%;">' + req.FileName + '</td>' +
                '<td style = "width:30%;">' + req.UploadedDate + '</td> <td style="width:30%;">'
                + req.ContentType + '</td></tr > ');

        });

        $('#downloadDataTableFulfill tr td:nth-child(1) a').click(function () {
            var fileid = $(this).closest('tr').find('td:eq(2)').html();
            //downloadFile(type, fileid);

            downloadFileTable(type, fileid, pmid, reqid)

            var $selectedRow = $(this).parent("td").parent("tr");
            $selectedRow.addClass("highlight").siblings().removeClass("highlight");
            $selectedRow.addClass("highlight");
        });
        $('#downloadDataTableFulfill tr td:nth-child(2) a').click(function () {
            var fileid = $(this).closest('tr').find('td:eq(2)').html();
//            deleteFile(type, fileid);
            deleteFileFulfill(type, fileid, pmid, reqid)

            var $selectedRow = $(this).parent("td").parent("tr");
            $selectedRow.addClass("highlight").siblings().removeClass("highlight");
            $selectedRow.addClass("highlight");
           // ShowUploadedFiles('');
        });
        
        $("#downloadModalfulfill").modal();

    }
    else if (data.length == 0 && type == "fulltext") {
        var Fturl = $("#FulltextURLfulfill").val();
        if (Fturl.length > 0) {
            window.open(Fturl, '_blank');
        }
        return false;
    }
}

function GetPMIDFilesRpt(type) {

    var pmidd = $('#pmidrpt').val();
    var hdnreqidd = $('#hdnreqidrpt').val();

    //var pmid = $('#pmid').val();
    var pmid = pmidd;
    if (pmid == '') {
        alert('PMID must not be empty');
        return false;
    }
    var reqid = $('#hdnreqidrpt').val();
    if (reqid == '') {
        alert('Please select record');
        return false;
    }
    var requestTable = $('#downloadDataTablerpt tbody');
    requestTable.empty();
    $.ajax({
        type: "GET",
        url: "FullPageRequestService.asmx/GetPMIDFiles",
        dataType: "json",
        data: {
            pmid: pmid,
            type: type,
            requestId: reqid,
        },
        async: true,
        success: function (data) {
            if (type == '') {
                var ftFilenames = '';
                var purchaseFileNames = '';
                $(data).each(function (index, req) {
                    if (req.Type == "fulltext")
                        ftFilenames += req.FileName + ',';
                    else if (req.Type == "supplement")
                        purchaseFileNames += req.FileName + ",";
                });
                $('#lblFTfilenamesrpt').html(ftFilenames);
                $('#lblpurchasefilenamesrpt').html(purchaseFileNames);
            }
            else {
                BindDownloadReportData(data, type, pmid, reqid);
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function BindDownloadReportData_old(data, type, pmid, reqid) {
    var requestTable = $('#downloadDataTablerpt tbody');
    requestTable.empty();

    var deletehtml = '';
    if (pageName == "FullTextRequest") {
        deletehtml = '<td style="display:none;width:25px;"><a><span style="color:red;" class="fa fa-remove" ></span></a></td>';
    }
    else if (pageName == "FullTextFullFiller") {
        deletehtml = '<td style="width:25px;"><a><span style="color:red;" class="fa fa-remove" ></span></a></td>';
    }
    //alert(JSON.stringify(data.length));
    if (data.length > 0) {
        $(data).each(function (index, req) {
            requestTable.append('<tr>' +
                '<td style="width:25px;"><a><span style="color:blue;" class="fa fa-cloud-download" ></span></a></td>' +
                deletehtml +
                '<td style="display:none;">' + req.FileID + '</td>' +
                '<td style="width:20%;">' + req.FileName + '</td>' +
                '<td style = "width:30%;">' + req.UploadedDate + '</td> <td style="width:30%;">'
                + req.ContentType + '</td></tr > ');

        });

        $('#downloadDataTablerpt tr td:nth-child(1) a').click(function () {
            var fileid = $(this).closest('tr').find('td:eq(2)').html();
            downloadFileTable(type, fileid, pmid, reqid)
            var $selectedRow = $(this).parent("td").parent("tr");
            $selectedRow.addClass("highlight").siblings().removeClass("highlight");
            $selectedRow.addClass("highlight");
        });
        //$('#downloadDataTablerpt tr td:nth-child(2) a').click(function () {
        //    var fileid = $(this).closest('tr').find('td:eq(2)').html();
        //    //            deleteFile(type, fileid);
        //    deleteFileFulfill(type, fileid, pmid, reqid)

        //    var $selectedRow = $(this).parent("td").parent("tr");
        //    $selectedRow.addClass("highlight").siblings().removeClass("highlight");
        //    $selectedRow.addClass("highlight");
        //});

        $("#downloadModalrpt").modal();

    }
    else if (data.length == 0 && type == "fulltext") {
        var Fturl = $("#FulltextURLrpt").val();
        if (Fturl.length > 0) {
            window.open(Fturl, '_blank');
        }
        return false;
    }
}
function checkDatachanged() {
    var button = $('#btnAdd');
    divRequestInfoi
    $('form :input').not(button).bind('keyup change', function () {
        // get all that inputs that has changed
        var changed = $('form :input').not(button).filter(function () {
            if (this.type == 'radio' || this.type == 'checkbox') {
                return this.checked != $(this).data('default');
            } else {
                return this.value != $(this).data('default');
            }
        });
        // disable if none have changed - else enable if at least one has changed
        $('#btnAdd').prop('disabled', !changed.length);
    });
}

//20200320 in use
function SendBulkRequests(pmid) {

    $.ajax({
        type: "GET",
        url: "FullPageRequestService.asmx/SearchBulkrequests",
        dataType: "json",
        data: {
            pmids: pmid
        },
        async: true,
        success: function (data) {
            //displayTable(data);
            displaybulkRequestsTable(data);
        },
        error: function (err) {
            console.log(err);
        }
    });
}

var bulkrequest_table;
function displaybulkRequestsTable(results) {
   // alert('displaybulkRequestsTable');
    bulkrequest_table= $('#bulkRequestTable').DataTable({
        destroy: true,
        data: results,
        // scrollY: "200px",
        paging: false,
        searching: false,
        "ordering": false,
        "info": false,
        fixedColumns: true,
        "columns": [
            {
                "sTitle": "PMID", "data": "PMID",
                render: function (data, type, full, meta) {
                    return '<a style="color: blue;">' + data + '</a>';
                },
            },
            { "sTitle": "JournalTitle", "data": "JournalTitle" },
            { "sTitle": "Title", "data": "Title" },
            { "sTitle": "Status", "data": "Status" },

            {
                "sTitle": "Actions", "data": "Status",
                "className": "center",
                "defaultContent": '<a class="bulkreq_download"><label class="fa fa-download" style="color: blue;" title="Click to Download"></label></a>',
                'render': function (data, type, full, meta) {
                    if (data == 'Fulfilled')
                        return '<a class="bulkreq_download"><label class="fa fa-download" style="color: blue;" title="Click to Download"></label></a>';
                    else if (data == 'Open Free Full Text' || data == 'Request' || data == 'Cancelled Request' )
                        return '<input title="Check to Request Fulltext" type="checkbox" name="id[]" value="' + $('<div/>').text(data).html() + '">';
                    else
                        return '';
                }
            },
            { "sTitle": "Record ID", "data": "RequestID", "targets": 5, "visible": false },
            { "sTitle": "FulltextURL", "data": "FulltextURL", "targets": 6, "visible": false },
        ],
        "rowCallback": function (row, data, index) {
            // if (data["isReopened"] == true && data["Status"] === "In Progress") {
            // $(row).css("background-color", "darkseagreen");
            // $(row).addClass("warning");
            // }

        }

    });
    
    $('#bulkRequestTable tr td:nth-child(1)').on('click', function (e) {
        var pmidvaluestr = $(this).closest('tr').find('td:eq(0)').html();
        var pmidvalue = pmidvaluestr.replace('<a style="color: blue;">', '');
        pmidvalue = pmidvalue.replace('</a>', '');
        if (pmidvalue.length > 0) {
            //var PubmedUrl = "https://www.ncbi.nlm.nih.gov/pubmed/?term=" + pmidvalue.trim(); 
            //20200319 commented above linek and Added link for New PubMed Site
            var PubmedUrl = "https://pubmed.ncbi.nlm.nih.gov/" + pmidvalue.trim() + "/?from_single_result=" + + pmidvalue.trim();
            var Fturl = PubmedUrl;
            if (Fturl.length > 0) {
                window.open(Fturl, '_blank');
            }
        }
        return false;

    });

    $('a.bulkreq_download').on('click', function (e) {
        var pmid = $(this).closest('tr').find('td:eq(0)').html();
     
        var tr = $(this).closest("tr");
        var idx = tr.index();
        reqid = $("#bulkRequestTable").dataTable().fnGetData(idx).RequestID;
        ftfile = $("#bulkRequestTable").dataTable().fnGetData(idx).FulltextURL;
        GetPMIDFilesTablebulk('Fulltext', pmid, reqid, ftfile)

    });

    $('#bulkRequestTable tbody').on('click', 'input[type="checkbox"]', function (e) {
        var $row = $(this).closest('tr');

        // Get row data
        //var data = table.row($row).data();

        //// Get row ID
        //var rowId = data[0];

        //// Determine whether row ID is in the list of selected row IDs
        //var index = $.inArray(rowId, rows_selected);

        //// If checkbox is checked and row ID is not in list of selected row IDs
        //if (this.checked && index === -1) {
        //    rows_selected.push(rowId);

        //    // Otherwise, if checkbox is not checked and row ID is in list of selected row IDs
        //} else if (!this.checked && index !== -1) {
        //    rows_selected.splice(index, 1);
        //}

        //if (this.checked) {
        //    $row.addClass('selected');
        //} else {
        //    $row.removeClass('selected');
        //}
        //// Prevent click event from propagating to parent
        //e.stopPropagation();
    });

    $("#bulkRequestModal").modal();

}


function GetPMIDFilesTablebulk(type, pmid, reqid, ftfile) {
    var pmidd = pmid; //JSON.stringify({ pmid: pmid });
    //JSON.stringify({ Username: sessionusername });
    var reqidd = reqid; // JSON.stringify({ reqid: reqid });

    if (pmidd == '') {
        return false;
    }
    if (reqidd == '') {
        return false;
    }
    //  GetPMIDFiles(type);

    pmidd = pmidd.replace('<a style="color: blue;">', '');
    pmidd = pmidd.replace('</a>', '');

    var requestTable = $('#downloadDataTablebulk tbody');
    requestTable.empty();
    $.ajax({
        type: "GET",
        //contentType: "application/json; charset=utf-8",
        url: "FullPageRequestService.asmx/GetPMIDFiles",
        dataType: "json",
        data: {
            pmid: pmidd,
            type: type,
            requestId: reqidd,
        },
        async: true,
        success: function (data) {
            if (type == '') {
            }
            else {
                BindDownloadDataTablebulk(data, type, pmidd, reqidd, ftfile);
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function BindDownloadDataTablebulk(data, type, pmid, hdnreqid, ftfile) {
   
    var requestTable = $('#downloadDataTablebulk').DataTable({
        destroy: true,
        data: data,
        // scrollY: "200px",
        paging: false,
        searching: false,
        "ordering": false,
        "info": false,
        fixedColumns: true,
        "columns": [
            {
                "sTitle": "Actions", "data": "",
                "className": "center",
                "text-align": "center",
                "defaultContent": '<a><span style="color:blue;" class="fa fa-cloud-download" title="Click here to download file"></span></a>',
            },
            { "sTitle": "File ID", "data": "FileID" },
            { "sTitle": "File Name", "data": "FileName" },
            { "sTitle": "FileType", "data": "ContentType" },
        ],
        "rowCallback": function (row, data, index) {
            // if (data["isReopened"] == true && data["Status"] === "In Progress") {
            // $(row).css("background-color", "darkseagreen");
            // $(row).addClass("warning");
            // }

        }

    });
    //alert(JSON.stringify(data.length));
    if (data.length > 0) {
        $('#downloadDataTablebulk tr td:nth-child(1) a').click(function () {
            var fileid = $(this).closest('tr').find('td:eq(1)').html();
            downloadFileTable('fulltext', fileid, pmid, hdnreqid);
            var $selectedRow = $(this).parent("td").parent("tr");
            $selectedRow.addClass("highlight").siblings().removeClass("highlight");
            $selectedRow.addClass("highlight");
        });
      
        $("#downloadModalbulk").modal();


    }
    else if (data.length == 0 && type.toLowerCase() == "fulltext") {
        var Fturl = ftfile;
        if (Fturl.length > 0) {
            window.open(Fturl, '_blank');
        }
        return false;
    }


}

//20200321 in use
function SaveBulkRequests() {
    var mulitpmids=[];
    var rows = $(bulkrequest_table.$('input[type="checkbox"]').map(function () {
        //return $(this).prop("checked") ? $(this).closest('tr').find('td:eq(0)').html() : null;
        // console.log($(this).prop("checked") ? $(this).closest('tr').find('td:eq(0)').html() : null);
        mulitpmids.push($(this).prop("checked") ? $(this).closest('tr').find('td:eq(0)').html().replace('<a style="color: blue;">', '').replace('</a>', '') : null);
    }));
    //alert(mulitpmids);
    var pmids = mulitpmids.toString();
    if (pmids.endsWith(",")) {
        while (pmids.endsWith(",")) {
            pmids = pmids.slice(0, -1);
        }
    }

    if (pmids == '') {
        alert('Select PMID(s) to submit');
    }

   //alert(pmids);

    //pmids = pmids.trim();
    if (pmids != '') {
        var request = {
                PMID: pmids,
                RequestedBy: sessionusername
                };
        $.ajax({
            type: "POST",
            url: "FullPageRequestService.asmx/SearchandSaveEachRequestComma", 
            data: "{'request':" + JSON.stringify(request) + "}",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: true,
            success: function (data) {

                if (data.d != '') {
                    var alertmsg = data.d;
                    SavesearchRequest();
                    GetSearchRequest_New();
                    alert(alertmsg);
                    $('#bulkRequestModal').modal('hide'); //20200410
                }
                
            },
            error: function (xhr, ajaxOptions, thrownError) {
                //alert(xhr.status);
                alert(xhr.responseText);
                //alert(thrownError);
                $('#errorMessage').html('Data not saved!');
                $('#errorMessage').show();
            }

        });

    }
}

//20200326
function BindDownloadDataTable(data, type, pmid, hdnreqid, ftfile) {

    var requestTable = $('#downloadDataTable').DataTable({
        destroy: true,
        data: data,
        // scrollY: "200px",
        paging: false,
        searching: false,
        "ordering": false,
        "info": false,
        fixedColumns: true,
        "columns": [
            {
                "sTitle": "Actions", "data": "",
                "className": "center",
                "text-align": "center", 
                "defaultContent": '<a><span style="color:blue;" class="fa fa-cloud-download" title="Click here to download file"></span></a>',
            },
            { "sTitle": "File ID", "data": "FileID" },
            { "sTitle": "File Name", "data": "FileName" },
            { "sTitle": "FileType", "data": "ContentType" },
        ],
        "rowCallback": function (row, data, index) {
            // if (data["isReopened"] == true && data["Status"] === "In Progress") {
            // $(row).css("background-color", "darkseagreen");
            // $(row).addClass("warning");
            // }

        }

    });
    
    if (data.length > 0) {

        $('#downloadDataTable tr td:nth-child(1) a').click(function () {
            var fileid = $(this).closest('tr').find('td:eq(1)').html();
            //alert(fileid);
            downloadFileTable('fulltext', fileid, pmid, hdnreqid);
            var $selectedRow = $(this).parent("td").parent("tr");
            $selectedRow.addClass("highlight").siblings().removeClass("highlight");
            $selectedRow.addClass("highlight");
        });

        $("#downloadModal").modal();


    }
    else if (data.length == 0 && type.toLowerCase() == "fulltext") {
        var Fturl = ftfile;
        if (Fturl.length > 0) {
            window.open(Fturl, '_blank');
        }
        return false;
    }
}

function BindDownloadfulfillData(data, type, pmid, reqid) {
   
    var requestTable = $('#downloadDataTableFulfill').DataTable({
        destroy: true,
        data: data,
        // scrollY: "200px",
        paging: false,
        searching: false,
        "ordering": false,
        "info": false,
        fixedColumns: true,
        "columns": [
            {
                "sTitle": "", "data": "",
                "className": "center",
                "text-align": "center",
                "defaultContent": '<a><span style="color:blue;" class="fa fa-cloud-download" title="Click here to download file"></span></a>',
            },
            {
                "sTitle": "", "data": "",
                "className": "center",
                "text-align": "center",
                "defaultContent": '<a><span style="color:red;" class="fa fa-remove" title="Click here to delete file"></span></a>',
            },
            { "sTitle": "File ID", "data": "FileID" },
            { "sTitle": "File Name", "data": "FileName" },
            { "sTitle": "File Type", "data": "ContentType" },
        ],
        
    });


    //alert(JSON.stringify(data.length));
    if (data.length > 0) {
      
        $('#downloadDataTableFulfill tr td:nth-child(1) a').click(function () {
            var fileid = $(this).closest('tr').find('td:eq(2)').html();
            //downloadFile(type, fileid);

            downloadFileTable(type, fileid, pmid, reqid)

            var $selectedRow = $(this).parent("td").parent("tr");
            $selectedRow.addClass("highlight").siblings().removeClass("highlight");
            $selectedRow.addClass("highlight");
        });
        $('#downloadDataTableFulfill tr td:nth-child(2) a').click(function () {
            var fileid = $(this).closest('tr').find('td:eq(2)').html();
            //            deleteFile(type, fileid);
            deleteFileFulfill(type, fileid, pmid, reqid)

            var $selectedRow = $(this).parent("td").parent("tr");
            $selectedRow.addClass("highlight").siblings().removeClass("highlight");
            $selectedRow.addClass("highlight");
            // ShowUploadedFiles('');
        });

        $("#downloadModalfulfill").modal();

    }
    else if (data.length == 0 && type == "fulltext") {
        var Fturl = $("#FulltextURLfulfill").val();
        if (Fturl.length > 0) {
            window.open(Fturl, '_blank');
        }
        return false;
    }
}

function BindDownloadReportData(data, type, pmid, reqid) {
    var requestTable = $('#downloadDataTablerpt').DataTable({
        destroy: true,
        data: data,
        // scrollY: "200px",
        paging: false,
        searching: false,
        "ordering": false,
        "info": false,
        fixedColumns: true,
        "columns": [
            {
                "sTitle": "Actions", "data": "",
                "className": "center",
                "text-align": "center",
                "defaultContent": '<a><span style="color:blue;" class="fa fa-cloud-download" title="Click here to download file"></span></a>',
            },
            { "sTitle": "File ID", "data": "FileID" },
            { "sTitle": "File Name", "data": "FileName" },
            { "sTitle": "FileType", "data": "ContentType" },
        ],
        "rowCallback": function (row, data, index) {
            // if (data["isReopened"] == true && data["Status"] === "In Progress") {
            // $(row).css("background-color", "darkseagreen");
            // $(row).addClass("warning");
            // }

        }

    });


    //alert(JSON.stringify(data.length));
    if (data.length > 0) {
       
        $('#downloadDataTablerpt tr td:nth-child(1) a').click(function () {
            var fileid = $(this).closest('tr').find('td:eq(1)').html();
            downloadFileTable(type, fileid, pmid, reqid)
            var $selectedRow = $(this).parent("td").parent("tr");
            $selectedRow.addClass("highlight").siblings().removeClass("highlight");
            $selectedRow.addClass("highlight");
        });

        $("#downloadModalrpt").modal();
    }
    else if (data.length == 0 && type == "fulltext") {
        var Fturl = $("#FulltextURLrpt").val();
        if (Fturl.length > 0) {
            window.open(Fturl, '_blank');
        }
        return false;
    }
}

function displayTableReport(results) {

    table = $('#requestDataTablerpt').DataTable({
        data: results,
        destroy: true,
       // scrollY: "500px",
        "scrollCollapse": true,
        "scrollX": true,
        searching: false,
        "ordering": false,
       // "info": false,
        "columns": [
          //  { "data": "RequestID" },
         //   { "data": "NESID" },
            {"sTitle": "PMID", "data": "PMID" },
            { "sTitle": "Title", "data": "Title" },
            { "sTitle": "Journal Title", "data": "JournalTitle" },
            { "sTitle": "FTRetrievedFrom", "data": "FTRetrievedFrom" },
            { "sTitle": "Status", "data": "Status" },
            { "sTitle": "Reviewed On", "data": "ReviewedOn" },
            { "sTitle": "Cost", "data": "Cost" },
            { "sTitle": "Cost Center", "data": "CostCenter" },

            { "sTitle": "Citation", "data": "Citation" },
            { "sTitle": "Instructions", "data": "Instructions" },
            { "sTitle": "Priority", "data": "Priority" },

            { "sTitle": "FulltextURL", "data": "FulltextURL" },
            { "sTitle": "FulltextFile", "data": "FulltextFile" },
            { "sTitle": "Notes", "data": "Notes" },

            { "sTitle": "RequestedOn", "data": "RequestedOn" },
            { "sTitle": "RequestedBy", "data": "RequestedBy" },
            { "sTitle": "ReviewedBy", "data": "ReviewedBy" },
            { "sTitle": "PubMedFTURL", "data": "PubMedFTURL" },
            { "sTitle": "EhostFTLink", "data": "EhostFTLink" },

        ],
        dom: 'Bfrtip',
        buttons: [
            { extend: 'csv', className: 'copyButton' },
            { extend: 'excelHtml5', className: 'buttons-excel buttons-html5' }
            //'csv','excelHtml5',
        ],
    });

    //var column = table.column(8);
    //column.visible(false);
    for (var i = 8; i <= 18; i++) {
        table.column(i).visible(false);
    }
    
    $('#requestDataTablerpt tbody').on('click', 'tr', function () {
        $(this).addClass("highlight").siblings().removeClass("highlight");
        $(this).addClass("highlight");
        var value = $(this).find('td:eq(0)').html();
        $('#hdnreqidrpt').val(value);
        //GetFulfillDetails(value);
        GetReportDetails(value); //ToDO:
        $("#myModal").modal();
    });
}

//20200415 In use
function sethdnfieldsAfterSave() {
    $('#hdnpriorityReq').val($('#Priority option:selected').text());
    $('#hdncostcenterReq').val($('#CostCenter option:selected').text());
    $('#hdnjtitleReq').val($('#journaltitle').val());
    $('#hdnANtitleReq').val($('#title').val());
    $('#hdncitationReq').val($('#Citation').val());
    $('#hdninstructionsReq').val($('#Instructions').val());
}

// Enables/disables Save button if any field changes
function InputChangeListener() {

    if ($("#hdnsavebtn").attr('disabled')) {
        // do sth if disabled
    }
    else {        // do sth if enabled 
        // var firstInput = document.getElementById("journaltitle");
        var priority1 = $('#hdnpriorityReq').val();
        var priority2 = $('#Priority option:selected').text();
        var CostCenter1 = $('#hdncostcenterReq').val();
        var CostCenter2 = $('#CostCenter option:selected').text();
        var jrtitle1 = $('#hdnjtitleReq').val();
        var jrtitle2 = $('#journaltitle').val();
        var ANtitle1 = $('#hdnANtitleReq').val();
        var ANtitle2 = $('#title').val();
        var citation1 = $('#hdncitationReq').val();
        var citation2 = $('#Citation').val();
        var instructions1 = $('#hdninstructionsReq').val();
        var instructions2 = $('#Instructions').val();
        //  var firstInputVal = document.getElementById("journaltitle").defaultValue;
        //alert(firstInputVal);
        if (priority2 == '--select--') {
            priority2 = '';
        }

        if (CostCenter2 == '--select--') {
            CostCenter2 = '';
        }

        if (priority1 == '--select--') {
            priority1 = '';
        }

        if (CostCenter1 == '--select--') {
            CostCenter1 = '';
        }


        if (priority1 == priority2 && CostCenter1 == CostCenter2 && jrtitle1 == jrtitle2 &&
            ANtitle1 == ANtitle2 && citation1 == citation2 && instructions1 == instructions2) {
            $('#btnAdd').attr("disabled", true);
            $('#btnAdd').removeClass("btn btn-success").addClass("btn btn-secondary");

        }
        else {
            $('#btnAdd').removeClass("btn btn-secondary").addClass("btn btn-success");
            $('#btnAdd').attr("disabled", false);
        }

    }

}






